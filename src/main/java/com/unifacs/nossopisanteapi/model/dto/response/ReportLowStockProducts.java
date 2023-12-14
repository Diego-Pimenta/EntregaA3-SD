package com.unifacs.nossopisanteapi.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ReportLowStockProducts(
    @JsonProperty("low_stock_products")
    List<ProductStockResponseDto> lowStockProducts
) {}
