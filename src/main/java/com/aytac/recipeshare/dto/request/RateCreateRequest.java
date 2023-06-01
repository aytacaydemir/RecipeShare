package com.aytac.recipeshare.dto.request;

public record RateCreateRequest(
        int rateValue,
        String userId,
        Long recipeId
) {
}
