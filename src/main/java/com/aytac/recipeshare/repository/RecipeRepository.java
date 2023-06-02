package com.aytac.recipeshare.repository;

import com.aytac.recipeshare.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findByIngredientsId(Long ingredientId);
}
