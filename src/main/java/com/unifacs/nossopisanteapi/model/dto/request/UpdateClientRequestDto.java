package com.unifacs.nossopisanteapi.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;

public record UpdateClientRequestDto(
    String name,

    @Email
    String email,

    String address,

    @JsonProperty(value="phone_number")
    String phoneNumber
){}
