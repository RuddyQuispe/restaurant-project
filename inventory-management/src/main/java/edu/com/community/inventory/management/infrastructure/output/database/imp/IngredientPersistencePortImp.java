package edu.com.community.inventory.management.infrastructure.output.database.imp;

import edu.com.community.inventory.management.application.input.dto.Ingredient;
import edu.com.community.inventory.management.application.output.IIngredientPersistencePort;
import edu.com.community.inventory.management.domain.helpers.PaginatedData;
import edu.com.community.inventory.management.domain.helpers.Paginator;
import edu.com.community.inventory.management.infrastructure.output.database.entities.IngredientEntity;
import edu.com.community.inventory.management.infrastructure.output.database.mappers.IIngredientPersistenceMapper;
import edu.com.community.inventory.management.infrastructure.output.database.repositories.IIngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IngredientPersistencePortImp implements IIngredientPersistencePort {

    private final IIngredientRepository repository;
    private final IIngredientPersistenceMapper mapper;

    @Override
    public Optional<Ingredient> findById(Integer id) {
        return this.repository.findById(id)
                .map(this.mapper::toDto);
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        IngredientEntity entity = this.mapper.toEntity(ingredient);
        entity = this.repository.save(entity);
        return this.mapper.toDto(entity);
    }

    @Override
    public PaginatedData<Ingredient> findByFilter(Ingredient ingredient, Paginator paginator) {
        Pageable pageable = PageRequest.of(paginator.pageNumber(), paginator.pageSize(), Sort.by(paginator.direction(), paginator.property()));
        Page<IngredientEntity> page = this.repository.findAllByFilters(ingredient.ingredientId(), ingredient.name(), ingredient.isEnabled(), ingredient.categoryId(), ingredient.unit().getAbbreviation(), pageable);
        List<Ingredient> usersDtoPage = this.mapper.toDtos(page.getContent());
        return new PaginatedData<>(usersDtoPage, page.getNumber(), page.getSize(), page.getTotalPages(), page.getTotalElements());
    }
}
