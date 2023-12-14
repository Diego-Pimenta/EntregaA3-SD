package com.unifacs.nossopisanteapi.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public record ReportConsumptionByClient(
    ClientResponseDto client,
    @JsonProperty("average_consumption")
    BigDecimal averageConsumption
) {}
