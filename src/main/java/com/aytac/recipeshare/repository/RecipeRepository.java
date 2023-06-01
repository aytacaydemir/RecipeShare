package com.aytac.recipeshare.repository;

import com.aytac.recipeshare.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
