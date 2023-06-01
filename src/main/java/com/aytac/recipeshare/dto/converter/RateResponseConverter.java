package com.aytac.recipeshare.dto.converter;

import com.aytac.recipeshare.dto.response.RateResponse;
import com.aytac.recipeshare.model.Rate;
import org.springframework.stereotype.Component;

@Component
public class RateResponseConverter {
    public RateResponse convert(Rate rate) {

        return new RateResponse(
                rate.getId(),
                rate.getUser().getId(),
                rate.getRecipe().getId(),
                rate.getRateValue()
        );
    }
}
