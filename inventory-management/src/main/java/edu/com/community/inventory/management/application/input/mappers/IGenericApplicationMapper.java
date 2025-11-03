package edu.com.community.inventory.management.application.input.mappers;

public interface IGenericApplicationMapper<DTO> {
    DTO copy(DTO source, DTO dto);
}
