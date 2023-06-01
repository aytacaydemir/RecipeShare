package com.aytac.recipeshare.dto.response;

public record IngredientUsageResponse(
        Long id,
        String name,
        int usageCount
) {
}
