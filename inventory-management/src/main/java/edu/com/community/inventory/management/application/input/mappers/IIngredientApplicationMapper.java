package edu.com.community.inventory.management.application.input.mappers;

import edu.com.community.inventory.management.application.input.dto.Ingredient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface IIngredientApplicationMapper extends IGenericApplicationMapper<Ingredient> {

    @Override
    default Ingredient copy(Ingredient source, Ingredient dto) {
        return this.copyDto(source, dto);
    }

    @Mappings({
            @Mapping(target = "ingredientId", source = "source.ingredientId"),
            @Mapping(target = "name", source = "dto.name"),
            @Mapping(target = "description", source = "dto.description"),
            @Mapping(target = "isEnabled", source = "dto.isEnabled"),
            @Mapping(target = "unit", source = "dto.unit"),
            @Mapping(target = "categoryId", source = "dto.categoryId"),
            @Mapping(target = "lastUser", source = "dto.lastUser"),
            @Mapping(target = "lastTime", source = "dto.lastTime")
    })
    Ingredient copyDto(Ingredient source, Ingredient dto);
}
