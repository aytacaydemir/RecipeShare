package com.aytac.recipeshare.controller;

import com.aytac.recipeshare.dto.request.RecipeCreateRequest;
import com.aytac.recipeshare.dto.request.RecipeUpdateRequest;
import com.aytac.recipeshare.dto.response.RecipeResponse;
import com.aytac.recipeshare.service.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public ResponseEntity<List<RecipeResponse>> getAllRecipes() {
        return ResponseEntity.ok(recipeService.getAllRecipes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipeResponse> getRecipeById(@PathVariable Long id) {
        return ResponseEntity.ok(recipeService.getRecipeById(id));
    }

    @GetMapping("/with-ingredient/{ingredientId}")
    public ResponseEntity<List<RecipeResponse>> getRecipesByIngredient(Long ingredientId) {
        return ResponseEntity.ok(recipeService.getRecipesByIngredient(ingredientId));
    }

    @PostMapping
    public ResponseEntity<RecipeResponse> createRecipe(@RequestBody RecipeCreateRequest request) {
        return ResponseEntity.ok(recipeService.createRecipe(request)); //responseEntity.created
    }

    @PutMapping("/{recipeId}")
    public ResponseEntity<RecipeResponse> updateRecipe(@PathVariable Long recipeId,
                                                       @RequestBody RecipeUpdateRequest request) {
        return ResponseEntity.ok(recipeService.updateRecipeById(recipeId, request));
    }

    @DeleteMapping("/{id}")
    public void deleteRecipeById(@PathVariable Long id) {
        recipeService.deleteRecipeById(id);
    }

}
