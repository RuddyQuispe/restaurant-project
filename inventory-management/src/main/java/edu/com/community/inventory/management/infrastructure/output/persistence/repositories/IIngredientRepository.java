package edu.com.community.inventory.management.infrastructure.output.persistence.repositories;

import edu.com.community.inventory.management.infrastructure.output.persistence.entities.IngredientEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IIngredientRepository extends JpaRepository<IngredientEntity, Integer> {

    @Query("""
            SELECT i
            FROM IngredientEntity i
            WHERE (:id IS NULL OR i.ingredientId = :id)
                AND (:name IS NULL OR i.name = :name)
                AND (:isEnabled IS NULL OR i.isEnabled = :isEnabled)
                AND (:categoryId IS NULL OR i.categoryId = :categoryId)
                AND (:unit IS NULL OR i.unit = :unit)
            """)
    Page<IngredientEntity> findAllByFilters(@Param("id") Integer id,
                                            @Param("name") String name,
                                            @Param("isEnabled") Boolean isEnabled,
                                            @Param("categoryId") Integer categoryId,
                                            @Param("unit") String unit,
                                            Pageable pageable);
}
