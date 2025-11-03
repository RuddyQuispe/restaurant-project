package edu.com.community.inventory.management.infrastructure.input.rest.mappers;

import edu.com.community.inventory.management.application.input.dto.Ingredient;
import edu.com.community.inventory.management.infrastructure.input.rest.dto.IngredientResponse;
import edu.com.community.inventory.management.infrastructure.input.rest.dto.IngredientRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface IIngredientRestInfrastructureMapper extends IGenericRestMapper<IngredientRequest, IngredientResponse, Ingredient> {

}
