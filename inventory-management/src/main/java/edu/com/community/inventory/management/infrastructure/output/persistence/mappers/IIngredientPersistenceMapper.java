package edu.com.community.inventory.management.infrastructure.output.persistence.mappers;

import edu.com.community.inventory.management.application.input.dto.Ingredient;
import edu.com.community.inventory.management.infrastructure.output.persistence.entities.IngredientEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface IIngredientPersistenceMapper {
    IngredientEntity toEntity(Ingredient dto);

    Ingredient toDto(IngredientEntity entity);

    List<Ingredient> toDtos(List<IngredientEntity> entities);
}
