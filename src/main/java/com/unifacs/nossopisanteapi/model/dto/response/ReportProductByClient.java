package com.unifacs.nossopisanteapi.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ReportProductByClient(
    ClientResponseDto client,
    @JsonProperty("products_lists")
    List<ProductStockResponseDto> productsLists
) {}
