package com.unifacs.nossopisanteapi.service.impl;

import com.unifacs.nossopisanteapi.model.dto.request.CreateProductStockRequestDto;
import com.unifacs.nossopisanteapi.model.dto.request.UpdateProductStockRequestDto;
import com.unifacs.nossopisanteapi.model.dto.response.ProductStockResponseDto;
import com.unifacs.nossopisanteapi.repository.ProductStockRepository;
import com.unifacs.nossopisanteapi.service.ProductStockService;
import com.unifacs.nossopisanteapi.service.mapper.ProductStockMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductStockServiceImpl implements ProductStockService {
    private final ProductStockRepository repository;

    private final ProductStockMapper mapper;

    @Override
    public ProductStockResponseDto createProductStock(CreateProductStockRequestDto createProductStockRequestDto) {
        var productStockToCreate = mapper.createProductStockRequestDtoToProduct(createProductStockRequestDto);

        var productStockCreated = repository.save(productStockToCreate);

        return mapper.productStockToProductStockResponseDto(productStockCreated);
    }

    @Override
    public ProductStockResponseDto getProductStock(UUID stockId) {
        var productStock = repository.findById(stockId).orElseThrow();

        return mapper.productStockToProductStockResponseDto(productStock);
    }

    @Override
    public List<ProductStockResponseDto> getAllProductsStock() {
        var productsStock = repository.findAll();

        return productsStock.stream()
            .map(mapper::productStockToProductStockResponseDto)
            .toList();
    }

    @Override
    public ProductStockResponseDto updateProductStock(UUID stockId, UpdateProductStockRequestDto updateProductStockRequestDto) {
        var productStockFound = repository.findById(stockId).orElseThrow();

        var productStockToUpdate = mapper.updateProductStockRequestDtoToProductStock(productStockFound, updateProductStockRequestDto);

        var productStockUpdated = repository.save(productStockToUpdate);

        return mapper.productStockToProductStockResponseDto(productStockUpdated);
    }

    @Override
    public void deleteProductStock(UUID stockId) {
        repository.findById(stockId).orElseThrow();
        repository.deleteById(stockId);
    }
}
