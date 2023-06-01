package com.aytac.recipeshare.dto.request;


import java.util.List;

public record RecipeUpdateRequest(
        String name,
        String description,
        List<Long> ingredients //ingredient id list
) {
}
