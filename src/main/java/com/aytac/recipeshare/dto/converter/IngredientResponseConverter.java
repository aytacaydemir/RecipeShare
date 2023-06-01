package com.aytac.recipeshare.dto.converter;

import com.aytac.recipeshare.dto.response.IngredientResponse;
import com.aytac.recipeshare.dto.response.IngredientUsageResponse;
import com.aytac.recipeshare.model.Ingredient;
import org.springframework.stereotype.Component;

@Component
public class IngredientResponseConverter {
    public IngredientResponse convertToIngredientResponse(Ingredient ingredient) {

        return new IngredientResponse(
                ingredient.getId(),
                ingredient.getName());
    }

    public IngredientUsageResponse convertToIngredientUsageResponse(Ingredient ingredient) {
        return new IngredientUsageResponse(
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getRecipes().size());
    }
}
