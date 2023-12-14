package com.unifacs.nossopisanteapi.model.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record SaleResponseDto(
    UUID id,
    ClientResponseDto client,
    List<ProductStockResponseDto> products,
    @JsonProperty("sold_at")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    LocalDateTime soldAt
) {}
