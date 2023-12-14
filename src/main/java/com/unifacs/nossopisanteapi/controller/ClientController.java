package com.unifacs.nossopisanteapi.controller;

import com.unifacs.nossopisanteapi.model.dto.request.CreateClientRequestDto;
import com.unifacs.nossopisanteapi.model.dto.request.UpdateClientRequestDto;
import com.unifacs.nossopisanteapi.model.dto.response.ClientResponseDto;
import com.unifacs.nossopisanteapi.service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientController {
    private final ClientService service;

    @PostMapping
    public ResponseEntity<ClientResponseDto> createClient(@RequestBody @Valid CreateClientRequestDto createClientRequestDto) {
        return ResponseEntity.status(CREATED).body(service.createClient(createClientRequestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDto> getClient(@PathVariable("id") UUID clientId) {
        return ResponseEntity.ok(service.getClient(clientId));
    }

    @GetMapping
    public ResponseEntity<List<ClientResponseDto>> getAllClients() {
        return ResponseEntity.ok(service.getAllClients());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientResponseDto> updateClient(
        @PathVariable("id") UUID clientId,
        @RequestBody @Valid UpdateClientRequestDto updateClientRequestDto
    ) {
        return ResponseEntity.ok(service.updateClient(clientId, updateClientRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable("id") UUID clientId) {
        service.deleteClient(clientId);
        return ResponseEntity.noContent().build();
    }
}
