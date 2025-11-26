package com.proyecto_final.backend.Controllers;

import com.proyecto_final.backend.DTO.LikeDTO;
import com.proyecto_final.backend.Services.LikeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/api/likes")
@CrossOrigin("*")
public class LikeController {

    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping("/toggle")
    public ResponseEntity<?> toggle(@RequestBody LikeDTO dto) {
        String status = likeService.toggleLike(dto);
        return ResponseEntity.ok(Collections.singletonMap("status", status));
    }
}