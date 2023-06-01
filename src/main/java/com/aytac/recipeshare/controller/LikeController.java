package com.aytac.recipeshare.controller;

import com.aytac.recipeshare.dto.request.LikeCreateRequest;
import com.aytac.recipeshare.dto.response.LikeResponse;
import com.aytac.recipeshare.service.LikeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/likes")
public class LikeController {

    //aynı user'ın iki defa like atamaması için kontrol eklenecek.
    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping
    public ResponseEntity<LikeResponse> createLike(@RequestBody LikeCreateRequest request) {
        return ResponseEntity.ok(likeService.createLike(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LikeResponse> deleteLikeById(@PathVariable Long id) {

        return ResponseEntity.ok(likeService.deleteLikeById(id));
    }

}
