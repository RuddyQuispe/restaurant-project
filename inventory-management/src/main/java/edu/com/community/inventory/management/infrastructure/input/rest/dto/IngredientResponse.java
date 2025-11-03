package edu.com.community.inventory.management.infrastructure.input.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.com.community.inventory.management.domain.enums.UnitTypeIngredient;

import java.time.LocalDateTime;

public record IngredientResponse(
        Integer ingredientId,
        String name,
        String description,
        Boolean isEnabled,
        UnitTypeIngredient unit,
        Integer categoryId,
        @JsonIgnore
        String lastUser,
        @JsonIgnore
        LocalDateTime lastTime
) {
}
