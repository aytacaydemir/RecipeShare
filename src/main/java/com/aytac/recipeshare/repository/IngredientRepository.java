package com.aytac.recipeshare.repository;

import com.aytac.recipeshare.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
