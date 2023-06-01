package com.aytac.recipeshare.dto.converter;

import com.aytac.recipeshare.dto.response.IngredientResponse;
import com.aytac.recipeshare.model.Ingredient;
import org.springframework.stereotype.Component;

@Component
public class IngredientResponseConverter {
    public IngredientResponse convert(Ingredient ingredient) {
        
        return new IngredientResponse(ingredient.getId(), ingredient.getName());
    }
}
