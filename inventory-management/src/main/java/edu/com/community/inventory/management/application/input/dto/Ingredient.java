package edu.com.community.inventory.management.application.input.dto;

import edu.com.community.inventory.management.domain.enums.UnitTypeIngredient;

import java.time.LocalDateTime;

public record Ingredient(
        Integer ingredientId,
        String name,
        String description,
        Boolean isEnabled,
        UnitTypeIngredient unit,
        Integer categoryId,
        String lastUser,
        LocalDateTime lastTime
) {
}
