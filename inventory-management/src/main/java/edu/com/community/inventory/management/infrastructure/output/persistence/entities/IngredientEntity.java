package edu.com.community.inventory.management.infrastructure.output.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "i_ingredient")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IngredientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id", nullable = false)
    private Integer ingredientId;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description", nullable = true)
    private String description;
    @Column(name = "is_enabled", nullable = false)
    private Boolean isEnabled;
    @Column(name = "unit", nullable = false)
    private String unit;
    @Column(name = "category_id", nullable = false)
    private Integer categoryId;
    @Column(name = "last_user", nullable = false)
    private String lastUser;
    @Column(name = "last_time", nullable = false)
    private LocalDateTime lastTime;
}
