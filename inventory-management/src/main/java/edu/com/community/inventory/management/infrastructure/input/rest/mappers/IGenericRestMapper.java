package edu.com.community.inventory.management.infrastructure.input.rest.mappers;

public interface IGenericRestMapper<REQUEST, RESPONSE, DTO> {
    RESPONSE toResponse(DTO dto);

    DTO toDto(REQUEST rquestDto);
}
