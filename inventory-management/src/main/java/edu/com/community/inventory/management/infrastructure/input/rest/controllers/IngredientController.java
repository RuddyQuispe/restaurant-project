package edu.com.community.inventory.management.infrastructure.input.rest.controllers;

import edu.com.community.inventory.management.application.input.IIngredientServicePort;
import edu.com.community.inventory.management.application.input.dto.Ingredient;
import edu.com.community.inventory.management.infrastructure.input.rest.dto.IngredientRequest;
import edu.com.community.inventory.management.infrastructure.input.rest.dto.IngredientResponse;
import edu.com.community.inventory.management.infrastructure.input.rest.mappers.IIngredientRestInfrastructureMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/inventory/v1/ingredient")
public class IngredientController extends IGenericController<Ingredient, Integer, IngredientRequest, IngredientResponse> {

    public IngredientController(IIngredientServicePort ingredientServicePort,
                                IIngredientRestInfrastructureMapper ingredientMapper) {
        super(ingredientServicePort, ingredientMapper);
    }
}
