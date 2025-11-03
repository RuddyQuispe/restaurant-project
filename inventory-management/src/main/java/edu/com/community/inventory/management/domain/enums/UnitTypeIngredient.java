package edu.com.community.inventory.management.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum UnitTypeIngredient {
    GRAM("Gramo", "g"),
    KILOGRAM("Kilogarmo", "kg"),
    MILLILITER("Milliliter", "ml"),
    LITER("Litro", "L");

    private String name;
    private String abbreviation;

    private UnitTypeIngredient(String name, String abbreviation) {
        this.name = name;
        this.abbreviation = abbreviation;
    }

    public String getName() {
        return name;
    }

    @JsonValue
    public String getAbbreviation() {
        return abbreviation;
    }

    @JsonCreator
    public static UnitTypeIngredient fromAbbreviation(String value) {
        return Arrays.stream(values())
                .filter(v -> v.getAbbreviation().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("Unidad de medida inválida"));
    }
}
