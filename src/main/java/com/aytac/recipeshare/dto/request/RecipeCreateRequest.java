package com.aytac.recipeshare.dto.request;

import java.util.List;

public record RecipeCreateRequest(
        String name,
        String description,
        String userId,
        List<Long> ingredients  //ingredient id list.
) {
}
