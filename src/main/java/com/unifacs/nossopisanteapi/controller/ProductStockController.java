package com.unifacs.nossopisanteapi.controller;

import com.unifacs.nossopisanteapi.model.dto.request.CreateProductStockRequestDto;
import com.unifacs.nossopisanteapi.model.dto.request.UpdateProductStockRequestDto;
import com.unifacs.nossopisanteapi.model.dto.response.ProductStockResponseDto;
import com.unifacs.nossopisanteapi.service.ProductStockService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product-stock")
public class ProductStockController {
    private final ProductStockService service;

    @PostMapping
    public ResponseEntity<ProductStockResponseDto> createProductStock(
        @RequestBody @Valid CreateProductStockRequestDto createProductStockRequestDto
    ) {
        return ResponseEntity.status(CREATED).body(service.createProductStock(createProductStockRequestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductStockResponseDto> getProductStock(@PathVariable("id") UUID stockId) {
        return ResponseEntity.ok(service.getProductStock(stockId));
    }

    @GetMapping
    public ResponseEntity<List<ProductStockResponseDto>> getAllProductsStock() {
        return ResponseEntity.ok(service.getAllProductsStock());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductStockResponseDto> updateProductStock(
        @PathVariable("id") UUID stockId,
        @RequestBody @Valid UpdateProductStockRequestDto updateProductStockRequestDto
    ) {
        return ResponseEntity.ok(service.updateProductStock(stockId, updateProductStockRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductStock(@PathVariable("id") UUID stockId) {
        service.deleteProductStock(stockId);
        return ResponseEntity.noContent().build();
    }
}
