package edu.com.community.inventory.management.application.input;

import edu.com.community.inventory.management.application.input.mappers.IGenericApplicationMapper;
import edu.com.community.inventory.management.application.output.IGenericPersistencePort;
import edu.com.community.inventory.management.domain.exception.ModelNotFoundException;
import edu.com.community.inventory.management.domain.helpers.PaginatedData;
import edu.com.community.inventory.management.domain.helpers.Paginator;

import java.util.Optional;

/**
 * service ports standard
 *
 * @param <ID>  Id Object
 * @param <DTO> DTO object
 */
public abstract class IGenericServicePort<DTO, ID> {

    protected final IGenericPersistencePort<DTO, ID> persistencePort;
    protected final IGenericApplicationMapper<DTO> mapper;

    public IGenericServicePort(IGenericPersistencePort<DTO, ID> persistencePort, IGenericApplicationMapper<DTO> mapper) {
        this.persistencePort = persistencePort;
        this.mapper = mapper;
    }

    public DTO create(DTO dto) {
        return this.persistencePort.save(dto);
    }

    public DTO update(ID id, DTO dto) {
        return this.persistencePort.findById(id)
                .map(o -> {
                    DTO dtoToUpdate = this.mapper.copy(o, dto);
                    return this.persistencePort.save(dtoToUpdate);
                })
                .orElseThrow(() -> new ModelNotFoundException("No se encontro el objeto con el id: %s".formatted(id)));
    }

    public void delete(ID id) {
        throw new UnsupportedOperationException("Proceso eliminar no implementado");
    }

    public Optional<DTO> findById(ID id) {
        return this.persistencePort.findById(id);
    }

    public PaginatedData<DTO> findAllByFilter(DTO filter, Paginator paginator) {
        return this.persistencePort.findByFilter(filter, paginator);
    }

}
