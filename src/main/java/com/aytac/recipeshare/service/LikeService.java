package com.aytac.recipeshare.service;

import com.aytac.recipeshare.dto.converter.LikeResponseConverter;
import com.aytac.recipeshare.dto.request.LikeCreateRequest;
import com.aytac.recipeshare.dto.response.LikeResponse;
import com.aytac.recipeshare.model.Like;
import com.aytac.recipeshare.model.Recipe;
import com.aytac.recipeshare.model.User;
import com.aytac.recipeshare.repository.LikeRepository;
import org.springframework.stereotype.Service;

@Service
public class LikeService {

    private final LikeRepository likeRepository;
    private final UserService userService;
    private final RecipeService recipeService;
    private final LikeResponseConverter converter;

    public LikeService(RecipeService recipeService, UserService userService,
                       LikeRepository likeRepository, LikeResponseConverter converter) {
        this.recipeService = recipeService;
        this.userService = userService;
        this.likeRepository = likeRepository;
        this.converter = converter;
    }

    public LikeResponse createLike(LikeCreateRequest request) {

        User user = userService.getUserById(request.userId());
        Recipe recipe = recipeService.getRecipeEntityById(request.recipeId());

        //duplicate like olmaması için kontrol eklenecek.
        Like like = new Like();
        like.setUser(user);
        like.setRecipe(recipe);
        likeRepository.save(like);

        return converter.convert(like);
    }

    public LikeResponse deleteLikeById(Long id){

        Like like = likeRepository.findById(id).orElse(null);

        likeRepository.deleteById(id);
        return converter.convert(like);
    }
}
