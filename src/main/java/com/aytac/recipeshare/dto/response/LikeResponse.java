package com.aytac.recipeshare.dto.response;

public record LikeResponse(
        Long id,
        Long recipeId,
        String userId
) {
}
