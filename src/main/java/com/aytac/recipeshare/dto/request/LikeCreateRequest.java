package com.aytac.recipeshare.dto.request;

public record
LikeCreateRequest (
    String userId,
    Long recipeId
){}
