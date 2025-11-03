package edu.com.community.inventory.management.application.output;

import edu.com.community.inventory.management.domain.helpers.PaginatedData;
import edu.com.community.inventory.management.domain.helpers.Paginator;

import java.util.Optional;

/**
 * interface standard for ABM objects
 *
 * @param <DTO> dto object
 * @param <ID>  id object
 */
public interface IGenericPersistencePort<DTO, ID> {
    Optional<DTO> findById(ID id);

    DTO save(DTO dto);

    PaginatedData<DTO> findByFilter(DTO dto, Paginator paginator);
}