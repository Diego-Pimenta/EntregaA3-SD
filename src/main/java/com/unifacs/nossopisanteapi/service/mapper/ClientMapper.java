package com.unifacs.nossopisanteapi.service.mapper;

import com.unifacs.nossopisanteapi.model.dto.request.CreateClientRequestDto;
import com.unifacs.nossopisanteapi.model.dto.request.UpdateClientRequestDto;
import com.unifacs.nossopisanteapi.model.dto.response.ClientResponseDto;
import com.unifacs.nossopisanteapi.model.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.util.StringUtils;

@Mapper(componentModel = "spring", imports = StringUtils.class)
public interface ClientMapper {
    @Mapping(target = "createdAt", expression = "java(LocalDateTime.now())")
    Client createClientRequestDtoToClient(CreateClientRequestDto createClientRequestDto);

    ClientResponseDto clientToClientResponseDto(Client client);

    @Mapping(
        target = "name",
        expression = "java(StringUtils.hasText(updateClientRequestDto.name()) ? updateClientRequestDto.name() : client.getName())"
    )
    @Mapping(
        target = "email",
        expression = "java(StringUtils.hasText(updateClientRequestDto.email()) ? updateClientRequestDto.email() : client.getEmail())"
    )
    @Mapping(
        target = "address",
        expression = "java(StringUtils.hasText(updateClientRequestDto.address()) ? updateClientRequestDto.address() : client.getAddress())"
    )
    @Mapping(
        target = "phoneNumber",
        expression = "java(StringUtils.hasText(updateClientRequestDto.phoneNumber()) ? updateClientRequestDto.phoneNumber() : client.getPhoneNumber())"
    )
    Client updateClientRequestDtoToClient(Client client, UpdateClientRequestDto updateClientRequestDto);
}
