package com.proyecto_final.backend.Controllers;

import com.proyecto_final.backend.DTO.CreatePostDTO;
import com.proyecto_final.backend.Models.Entity.Media;
import com.proyecto_final.backend.Models.Entity.Post;
import com.proyecto_final.backend.Services.LikeService;
import com.proyecto_final.backend.Services.MediaService;
import com.proyecto_final.backend.Services.PostService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin("*")
public class PostController {

    private final PostService postService;
    private final MediaService mediaService;
    private final LikeService likeService;

    public PostController(PostService postService, MediaService mediaService, LikeService likeService) {
        this.postService = postService;
        this.mediaService = mediaService;
        this.likeService = likeService;
    }

    @PostMapping
    public ResponseEntity<Post> create(@RequestBody CreatePostDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(postService.create(dto));
    }

    @GetMapping
    public ResponseEntity<?> all() {
        return ResponseEntity.ok(postService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> get(@PathVariable String id) {
        return ResponseEntity.ok(postService.getById(id));
    }

    @PostMapping("/{id}/media")
    public Media addMedia(@PathVariable String id, @RequestBody Map<String,String> body) {
        return mediaService.addMedia(id, body.get("url"), body.get("tipo"));
    }

    @GetMapping("/{id}/likes")
    public long likes(@PathVariable String id) {
        return likeService.countLikes(id);
    }
}