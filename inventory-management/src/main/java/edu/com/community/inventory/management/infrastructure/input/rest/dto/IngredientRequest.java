package edu.com.community.inventory.management.infrastructure.input.rest.dto;

import edu.com.community.inventory.management.domain.enums.UnitTypeIngredient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record IngredientRequest(
        @NotBlank(message = "El nombre es obligatorio")
        @Size(max = 50, message = "El nombre no puede ser mayor a 50 caracteres")
        String name,
        @Size(max = 100, message = "La description no puede ser mayor a 100 caracteres")
        String description,
        @NotNull(message = "El estado es obligatorio")
        Boolean isEnabled,
        @NotNull(message = "El tipo de unidad es obligatorio")
        UnitTypeIngredient unit,
        @NotNull(message = "El id de la categoria es obligatorio")
        Integer categoryId) {
}
