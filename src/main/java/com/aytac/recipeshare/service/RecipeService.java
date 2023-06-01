package com.aytac.recipeshare.service;

import com.aytac.recipeshare.dto.converter.RecipeResponseConverter;
import com.aytac.recipeshare.dto.request.RecipeCreateRequest;
import com.aytac.recipeshare.dto.request.RecipeUpdateRequest;
import com.aytac.recipeshare.dto.response.RecipeResponse;
import com.aytac.recipeshare.model.Recipe;
import com.aytac.recipeshare.model.User;
import com.aytac.recipeshare.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeResponseConverter converter;
    private final UserService userService;
    private final IngredientService ingredientService;

    public RecipeService(UserService userService,
                         IngredientService ingredientService,
                         RecipeRepository recipeRepository,
                         RecipeResponseConverter converter) {
        this.userService = userService;
        this.converter = converter;
        this.recipeRepository = recipeRepository;
        this.ingredientService = ingredientService;
    }

    public List<RecipeResponse> getAllRecipes() {
        return recipeRepository.findAll().stream()
                .map(converter::convert).collect(Collectors.toList());
    }

    public RecipeResponse createRecipe(RecipeCreateRequest request) {

        User user = userService.getUserById(request.userId());

        Recipe recipe = new Recipe();
        recipe.setCreateTime(LocalDateTime.now());
        recipe.setName(request.name());
        recipe.setDescription(request.description());
        recipe.setUser(user);
        recipe.setIngredients(request.ingredients().stream()
                .map(ingredientService::getIngredientById).collect(Collectors.toList()));

        recipeRepository.save(recipe);

        return converter.convert(recipe);
    }

    public RecipeResponse updateRecipeById(Long recipeId, RecipeUpdateRequest request) {

        Recipe recipe = recipeRepository.findById(recipeId).orElse(null); //throw recipe not found exception

        if (recipe != null) {
            recipe.setName(request.name());
            recipe.setDescription(request.description());
            recipe.setIngredients(request.ingredients());

            recipeRepository.save(recipe);
        } else {
            return null; //recipe not found ??
        }

        return converter.convert(recipe);
    }

    public RecipeResponse getRecipeById(Long recipeId) {  //return RecipeResponse??

        Recipe recipe = recipeRepository.findById(recipeId).orElse(null);
        return converter.convert(recipe);
    }

    public Recipe getRecipeEntityById(Long recipeId) {
        return recipeRepository.findById(recipeId).orElse(null);
    }

    public void deleteRecipeById(Long id){
        recipeRepository.deleteById(id);
    }
}
