package com.unifacs.nossopisanteapi.model.dto.response;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductStockResponseDto(
    UUID id,

    String nameProduct,

    int quantity,

    String brand,

    BigDecimal price,

    String category
) {}
