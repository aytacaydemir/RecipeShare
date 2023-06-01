package com.aytac.recipeshare.dto.request;

import com.aytac.recipeshare.model.Ingredient;

import java.util.List;

public record RecipeUpdateRequest(
        String name,
        String description,
        List<Ingredient> ingredients
) {
}
