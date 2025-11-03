package edu.com.community.inventory.management.application.input;

import edu.com.community.inventory.management.application.input.mappers.IGenericApplicationMapper;
import edu.com.community.inventory.management.application.output.IGenericPersistencePort;
import edu.com.community.inventory.management.application.input.dto.Ingredient;

public abstract class IIngredientServicePort extends IGenericServicePort<Ingredient, Integer> {
    public IIngredientServicePort(IGenericPersistencePort<Ingredient, Integer> persistencePort, IGenericApplicationMapper<Ingredient> mapper) {
        super(persistencePort, mapper);
    }
}
