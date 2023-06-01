package com.aytac.recipeshare.dto.converter;

import com.aytac.recipeshare.dto.response.LikeResponse;
import com.aytac.recipeshare.model.Like;
import org.springframework.stereotype.Component;

@Component
public class LikeResponseConverter {

    public LikeResponse convert(Like like){

        return new LikeResponse(
                like.getId(),
                like.getRecipe().getId(),
                like.getUser().getId()
        );
    }
}
