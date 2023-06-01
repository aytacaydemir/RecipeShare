package com.aytac.recipeshare.controller;

import com.aytac.recipeshare.dto.request.RateCreateRequest;
import com.aytac.recipeshare.dto.response.RateResponse;
import com.aytac.recipeshare.service.RateService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rates")
public class RateController {

    private final RateService rateService;
    public RateController(RateService rateService){
        this.rateService = rateService;
    }
    @PostMapping
    public RateResponse createRate(@Valid @RequestBody RateCreateRequest request){
        return rateService.createRate(request);
    }
}
