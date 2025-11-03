package edu.com.community.inventory.management.application.input.impl;

import edu.com.community.inventory.management.application.input.IIngredientServicePort;
import edu.com.community.inventory.management.application.input.mappers.IIngredientApplicationMapper;
import edu.com.community.inventory.management.application.output.IIngredientPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientServicePortImp extends IIngredientServicePort {

    @Autowired
    public IngredientServicePortImp(IIngredientPersistencePort ingredientPersistencePort,
                                    IIngredientApplicationMapper mapper) {
        super(ingredientPersistencePort, mapper);
    }
}
