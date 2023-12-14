package com.unifacs.nossopisanteapi.service.impl;

import com.unifacs.nossopisanteapi.model.dto.request.CreateClientRequestDto;
import com.unifacs.nossopisanteapi.model.dto.request.UpdateClientRequestDto;
import com.unifacs.nossopisanteapi.model.dto.response.ClientResponseDto;
import com.unifacs.nossopisanteapi.repository.ClientRepository;
import com.unifacs.nossopisanteapi.service.ClientService;
import com.unifacs.nossopisanteapi.service.mapper.ClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository repository;

    private final ClientMapper mapper;

    @Override
    public ClientResponseDto createClient(CreateClientRequestDto createClientRequestDto) {
        var clientToCreate = mapper.createClientRequestDtoToClient(createClientRequestDto);

        var clientCreated = repository.save(clientToCreate);

        return mapper.clientToClientResponseDto(clientCreated);
    }

    @Override
    public ClientResponseDto getClient(UUID clientId) {
        var client = repository.findById(clientId).orElseThrow();

        return mapper.clientToClientResponseDto(client);
    }

    @Override
    public List<ClientResponseDto> getAllClients() {
        var clients = repository.findAll();

        return clients.stream()
            .map(mapper::clientToClientResponseDto)
            .toList();
    }

    @Override
    public ClientResponseDto updateClient(UUID clientId, UpdateClientRequestDto updateClientRequestDto) {
        var clientFound = repository.findById(clientId).orElseThrow();
        var clientToUpdate = mapper.updateClientRequestDtoToClient(clientFound, updateClientRequestDto);
        var clientUpdated = repository.save(clientToUpdate);

        return mapper.clientToClientResponseDto(clientUpdated);
    }

    @Override
    public void deleteClient(UUID clientId) {
        repository.findById(clientId).orElseThrow();
        repository.deleteById(clientId);
    }
}
