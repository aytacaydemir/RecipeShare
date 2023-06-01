package com.aytac.recipeshare.dto.response;

import java.time.LocalDateTime;
import java.util.List;

public record RecipeResponse(
        Long id,
        String name,
        String description,
        LocalDateTime createTime,
        LocalDateTime updateTime,
        String userId,
        String userName,
        List<IngredientResponse> ingredients,
        int likeCount,
        double rateAverageValue

        ) {
}
