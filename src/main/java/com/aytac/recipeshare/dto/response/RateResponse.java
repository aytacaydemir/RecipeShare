package com.aytac.recipeshare.dto.response;

public record RateResponse(
        Long id,
        String userId,
        Long recipeId,
        int rateValue
) {
}
