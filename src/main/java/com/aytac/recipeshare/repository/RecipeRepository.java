package com.aytac.recipeshare.repository;

import com.aytac.recipeshare.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findByIngredientsId(Long ingredientId);

    /*SELECT DISTINCT r FROM Recipe
    r JOIN r.ingredients i
    WHERE LOWER(i.name)
    LIKE %:ingredientName%
    OR LOWER(r.name)
    LIKE %:recipeName%*/
    List<Recipe> findDistinctByIngredientsNameIgnoreCaseInOrNameContainingIgnoreCase(
            List<String> ingredientNames, String recipeName);
}
