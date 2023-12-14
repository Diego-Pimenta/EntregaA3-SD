package com.unifacs.nossopisanteapi.service;

import com.unifacs.nossopisanteapi.model.dto.request.CreateProductStockRequestDto;
import com.unifacs.nossopisanteapi.model.dto.request.UpdateProductStockRequestDto;
import com.unifacs.nossopisanteapi.model.dto.response.ProductStockResponseDto;

import java.util.List;
import java.util.UUID;

public interface ProductStockService {
    ProductStockResponseDto createProductStock(CreateProductStockRequestDto createProductStockRequestDto);
    ProductStockResponseDto getProductStock(UUID stockId);
    List<ProductStockResponseDto> getAllProductsStock();
    ProductStockResponseDto updateProductStock(UUID stockId, UpdateProductStockRequestDto updateProductStockRequestDto);
    void deleteProductStock(UUID stockId);
}
