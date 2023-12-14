package com.unifacs.nossopisanteapi.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record SaleRequestDto(
    @NotBlank
    @JsonProperty("client_id")
    String clientId,
    @NotEmpty
    @JsonProperty("products_id")
    List<@NotBlank String> productsId
) {}
