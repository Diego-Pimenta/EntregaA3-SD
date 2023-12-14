package com.unifacs.nossopisanteapi.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ReportMostSoldProduct(
    @JsonProperty("most_sold_product")
    ProductStockResponseDto mostSoldProduct
) {
}
