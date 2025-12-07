package com.proyecto_final.backend.Controllers;

import com.proyecto_final.backend.DTO.LikeDTO;
import com.proyecto_final.backend.Services.LikeService;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/likes")
@CrossOrigin(origins = "*")
public class LikeController {

    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping("/toggle")
    public ResponseEntity<?> toggle(@Valid @RequestBody LikeDTO dto) {
        String result = likeService.toggleLike(dto);
        return ResponseEntity.ok(Map.of("status", result));
    }

    // HEAD
    @RequestMapping(method = RequestMethod.HEAD)
    public ResponseEntity<Void> head() {
        return ResponseEntity.ok().build();
    }

    // OPTIONS
    @RequestMapping(method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> options() {
        return ResponseEntity.ok().build();
    }
}
