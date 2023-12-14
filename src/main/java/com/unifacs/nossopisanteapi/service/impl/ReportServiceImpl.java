package com.unifacs.nossopisanteapi.service.impl;

import com.unifacs.nossopisanteapi.model.dto.response.ReportConsumptionByClient;
import com.unifacs.nossopisanteapi.model.dto.response.ReportLowStockProducts;
import com.unifacs.nossopisanteapi.model.dto.response.ReportMostSoldProduct;
import com.unifacs.nossopisanteapi.model.dto.response.ReportProductByClient;
import com.unifacs.nossopisanteapi.model.entity.ProductStock;
import com.unifacs.nossopisanteapi.model.entity.Sale;
import com.unifacs.nossopisanteapi.repository.ProductStockRepository;
import com.unifacs.nossopisanteapi.repository.SaleRepository;
import com.unifacs.nossopisanteapi.service.ReportService;
import com.unifacs.nossopisanteapi.service.mapper.ClientMapper;
import com.unifacs.nossopisanteapi.service.mapper.ProductStockMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {
    private final SaleRepository saleRepository;
    private final ProductStockRepository productStockRepository;
    private final ProductStockMapper  productStockMapper;
    private final ClientMapper clientMapper;

    @Override
    public ReportMostSoldProduct getMostSoldProduct() {
        var sales = saleRepository.findAll();

        var products = sales.stream()
            .map(Sale::getProducts)
            .flatMap(Collection::stream)
            .toList();

        var productsIds = products.stream()
            .map(ProductStock::getId)
            .toList();

        var map = productsIds.stream()
            .collect(Collectors.toMap(id -> Collections.frequency(productsIds, id), id -> id));

        var mostSoldProductId = map.get(Collections.max(map.keySet()));

        var mostSoldProduct = products.stream()
            .filter(product -> product.getId().equals(mostSoldProductId))
            .findFirst()
            .orElseThrow();

        return new ReportMostSoldProduct(productStockMapper.productStockToProductStockResponseDto(mostSoldProduct));
    }

    @Override
    public ReportProductByClient getProductByClient(UUID clientId) {
        var sales = saleRepository.findAll();

        var client = sales.stream()
            .filter(sale -> sale.getClient().getId().equals(clientId))
            .findFirst()
            .map(Sale::getClient)
            .map(clientMapper::clientToClientResponseDto)
            .orElseThrow();

        var productsByClient = sales.stream()
            .filter(sale -> sale.getClient().getId().equals(clientId))
            .map(Sale::getProducts)
            .flatMap(Collection::stream)
            .map(productStockMapper::productStockToProductStockResponseDto)
            .toList();

        return new ReportProductByClient(client, productsByClient);
    }

    @Override
    public ReportConsumptionByClient getConsumptionByClient(UUID clientId) {
        var sales = saleRepository.findAll();

        var client = sales.stream()
        .filter(sale -> sale.getClient().getId().equals(clientId))
        .findFirst()
        .map(Sale::getClient)
        .map(clientMapper::clientToClientResponseDto)
        .orElseThrow();

        var averageConsumptionByClient = sales.stream()
            .filter(sale -> sale.getClient().getId().equals(clientId))
            .map(Sale::getProducts)
            .flatMap(Collection::stream)
            .map(ProductStock::getPrice)
            .reduce(BigDecimal.ZERO, BigDecimal::add);

        return new ReportConsumptionByClient(client, averageConsumptionByClient);
    }

    @Override
    public ReportLowStockProducts getLowStockProducts() {
        var productsStock = productStockRepository.findAll();

        var lowStockProducts = productsStock.stream()
            .filter(productStock -> productStock.getQuantity() < 10)
            .map(productStockMapper::productStockToProductStockResponseDto)
            .toList();

        return new ReportLowStockProducts(lowStockProducts);
    }
}
