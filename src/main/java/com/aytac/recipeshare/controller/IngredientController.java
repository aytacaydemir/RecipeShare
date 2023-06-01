package com.aytac.recipeshare.controller;

import com.aytac.recipeshare.dto.request.IngredientCreateRequest;
import com.aytac.recipeshare.dto.response.IngredientResponse;
import com.aytac.recipeshare.dto.response.IngredientUsageResponse;
import com.aytac.recipeshare.service.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public ResponseEntity<List<IngredientResponse>> getIngredients() {
        return ResponseEntity.ok(ingredientService.getIngredients());
    }

    @GetMapping("/top-five")
    public ResponseEntity<List<IngredientUsageResponse>> getTopFiveIngredients(){
        return ResponseEntity.ok(ingredientService.getTopFiveIngredients());
    }

    @PostMapping
    public ResponseEntity<IngredientResponse> createIngredient(@RequestBody IngredientCreateRequest request){
        return ResponseEntity.ok(ingredientService.createIngredient(request));
    }



}
