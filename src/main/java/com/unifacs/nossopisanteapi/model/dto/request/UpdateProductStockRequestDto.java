package com.unifacs.nossopisanteapi.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;

import java.math.BigDecimal;

public record UpdateProductStockRequestDto(
    @JsonProperty(value = "name_product")
    String nameProduct,

    @Min(0)
    Integer quantity,

    String brand,

    @Min(0)
    BigDecimal price,

    String category
) {
}
