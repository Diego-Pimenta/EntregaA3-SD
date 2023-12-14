package com.unifacs.nossopisanteapi.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CreateProductStockRequestDto(
    @NotBlank
    @JsonProperty(value = "name_product")
    String nameProduct,

    @Min(0)
    int quantity,

    @NotBlank
    String brand,

    @Min(0)
    @NotNull
    BigDecimal price,

    @NotBlank
    String category
) {}
