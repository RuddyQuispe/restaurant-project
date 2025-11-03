package edu.com.community.inventory.management.infrastructure.input.rest.dto;

import edu.com.community.inventory.management.domain.enums.UnitTypeIngredient;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;

public record IngredientRequest(
        @NotBlank(message = "El nombre es obligatorio")
        @Max(value = 50, message = "El nombre no puede ser mayor a 50 caracteres")
        String name,
        @Max(value = 100, message = "La description no puede ser mayor a 100 caracteres")
        String description,
        Boolean isEnabled,
        @NotBlank(message = "El tipo de unidad es obligatorio")
        UnitTypeIngredient unit,
        @NotBlank(message = "El id de la categoria es obligatorio")
        Integer categoryId) {
}
