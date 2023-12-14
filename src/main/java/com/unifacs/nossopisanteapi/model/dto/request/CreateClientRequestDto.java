package com.unifacs.nossopisanteapi.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateClientRequestDto(
    @NotBlank
    String name,

    @Email
    @NotBlank
    String email,

    @NotBlank
    String address,

    @NotBlank
    @JsonProperty(value = "phone_number")
    String phoneNumber
) {}
