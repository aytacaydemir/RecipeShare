package com.aytac.recipeshare.service;

import com.aytac.recipeshare.dto.converter.IngredientResponseConverter;
import com.aytac.recipeshare.dto.request.IngredientCreateRequest;
import com.aytac.recipeshare.dto.response.IngredientResponse;
import com.aytac.recipeshare.model.Ingredient;
import com.aytac.recipeshare.repository.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;
    private final IngredientResponseConverter converter;

    public IngredientService(IngredientRepository ingredientRepository, IngredientResponseConverter converter) {
        this.ingredientRepository = ingredientRepository;
        this.converter = converter;
    }

    public List<IngredientResponse> getIngredients() {
        List<Ingredient> ingredients = ingredientRepository.findAll();

        return ingredients.stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }

    public IngredientResponse createIngredient(IngredientCreateRequest request) {

        Ingredient ingredient = new Ingredient();
        ingredient.setName(request.name());

        return converter.convert(ingredientRepository.save(ingredient));
    }

    public Ingredient getIngredientById(Long id){
        return ingredientRepository.findById(id).orElse(null);
    }
}
