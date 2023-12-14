package com.unifacs.nossopisanteapi.service;

import com.unifacs.nossopisanteapi.model.dto.request.CreateClientRequestDto;
import com.unifacs.nossopisanteapi.model.dto.request.UpdateClientRequestDto;
import com.unifacs.nossopisanteapi.model.dto.response.ClientResponseDto;

import java.util.List;
import java.util.UUID;

public interface ClientService {
    ClientResponseDto createClient(CreateClientRequestDto createClientRequestDto);
    ClientResponseDto getClient(UUID clientId);
    List<ClientResponseDto> getAllClients();
    ClientResponseDto updateClient(UUID clientId, UpdateClientRequestDto updateClientRequestDto);
    void deleteClient(UUID clientId);
}
