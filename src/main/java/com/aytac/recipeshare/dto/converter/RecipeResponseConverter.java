package com.aytac.recipeshare.dto.converter;

import com.aytac.recipeshare.dto.response.RecipeResponse;
import com.aytac.recipeshare.model.Rate;
import com.aytac.recipeshare.model.Recipe;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class RecipeResponseConverter {

    private final IngredientResponseConverter IngredientResponseConverter;

    public RecipeResponseConverter(IngredientResponseConverter IngredientResponseConverter) {
        this.IngredientResponseConverter = IngredientResponseConverter;
    }

    public RecipeResponse convert(Recipe recipe) {

       /* System.out.println(recipe.getRates().stream()
                .map(Rate::getRateValue)
                .mapToDouble(d -> d)
                .average().orElse(0.0));*/
        return new RecipeResponse(
                recipe.getId(),
                recipe.getName(),
                recipe.getDescription(),
                recipe.getCreateTime(),
                recipe.getUpdateTime(),
                recipe.getUser().getId(),          //user için ayrı bir converter oluşturulabilir.
                recipe.getUser().getUsername(),
                recipe.getIngredients().stream()
                        .map(IngredientResponseConverter::convert)
                        .collect(Collectors.toList()),
                recipe.getLikes().size(),
                Math.round(recipe.getRates().stream()
                        .map(Rate::getRateValue)
                        .mapToDouble(d -> d)
                        .average().orElse(0.0))
        );
    }
}
