package com.aytac.recipeshare.service;

import com.aytac.recipeshare.dto.converter.RateResponseConverter;
import com.aytac.recipeshare.dto.request.RateCreateRequest;
import com.aytac.recipeshare.dto.response.RateResponse;
import com.aytac.recipeshare.model.Rate;
import com.aytac.recipeshare.model.Recipe;
import com.aytac.recipeshare.model.User;
import com.aytac.recipeshare.repository.RateRepository;
import org.springframework.stereotype.Service;

@Service
public class RateService {

    private final RateRepository rateRepository;
    private final UserService userService;
    private final RecipeService recipeService;
    private final RateResponseConverter converter;

    public RateService(RateRepository rateRepository,
                       UserService userService,
                       RecipeService recipeService,
                       RateResponseConverter converter){
        this.rateRepository = rateRepository;
        this.userService= userService;
        this.recipeService = recipeService;
        this.converter = converter;
    }

    public RateResponse createRate(RateCreateRequest request){

        User user = userService.getUserById(request.userId());
        Recipe recipe = recipeService.getRecipeEntityById(request.recipeId());

        Rate rate = new Rate();
        rate.setRateValue(request.rateValue());
        rate.setUser(user);
        rate.setRecipe(recipe);

        rateRepository.save(rate);

        return converter.convert(rate);
    }
}
