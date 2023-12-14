package com.unifacs.nossopisanteapi.model.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.UUID;

public record ClientResponseDto(
    UUID id,
    String name,
    String email,
    String address,
    @JsonProperty("phone_number")
    String phoneNumber,
    @JsonProperty("created_at")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    LocalDateTime createdAt
){}
