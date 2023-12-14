package com.unifacs.nossopisanteapi.service.impl;

import com.unifacs.nossopisanteapi.model.dto.request.SaleRequestDto;
import com.unifacs.nossopisanteapi.model.dto.response.SaleResponseDto;
import com.unifacs.nossopisanteapi.model.entity.Client;
import com.unifacs.nossopisanteapi.model.entity.ProductStock;
import com.unifacs.nossopisanteapi.repository.ClientRepository;
import com.unifacs.nossopisanteapi.repository.ProductStockRepository;
import com.unifacs.nossopisanteapi.repository.SaleRepository;
import com.unifacs.nossopisanteapi.service.SaleService;
import com.unifacs.nossopisanteapi.service.mapper.SaleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SaleServiceImpl implements SaleService {
    private final SaleRepository repository;
    private final SaleMapper mapper;
    private final ClientRepository clientRepository;
    private final ProductStockRepository productStockRepository;

    @Override
    public SaleResponseDto registerSale(SaleRequestDto saleRequestDto) {
        var saleToRegister = mapper.saleRequestDtoToSale(saleRequestDto);
        saleToRegister.setClient(getClientById(saleRequestDto.clientId()));
        var products = saleRequestDto.productsId().stream()
            .map(this::getProductStockById)
            .toList();
        saleToRegister.setProducts(products);

        var saleRegistered = repository.save(saleToRegister);

        return mapper.saleToSaleResponseDto(saleRegistered);
    }

    private Client getClientById(String clientId) {
        return clientRepository.findById(UUID.fromString(clientId)).orElseThrow();
    }

    private ProductStock getProductStockById(String productStockId) {
        var productStock = productStockRepository.findById(UUID.fromString(productStockId)).orElseThrow();
        productStock.setQuantity(productStock.getQuantity() - 1);
        return productStock;
    }
}
