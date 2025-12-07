package com.proyecto_final.backend.Controllers;

import com.proyecto_final.backend.DTO.CreatePostDTO;
import com.proyecto_final.backend.Models.Entity.Media;
import com.proyecto_final.backend.Models.Entity.Post;
import com.proyecto_final.backend.Services.LikeService;
import com.proyecto_final.backend.Services.MediaService;
import com.proyecto_final.backend.Services.PostService;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = "*")
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
    public ResponseEntity<Post> create(@Valid @RequestBody CreatePostDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(postService.create(dto));
    }

    @GetMapping
    public ResponseEntity<?> all() {
        return ResponseEntity.ok(postService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getById(@PathVariable String id) {
        return ResponseEntity.ok(postService.getById(id));
    }

    @PostMapping("/{id}/media")
    public ResponseEntity<Media> addMedia(@PathVariable String id, @RequestBody Map<String, String> body) {
        Media created = mediaService.addMedia(id, body.get("url"), body.get("tipo"));
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}/likes")
    public ResponseEntity<?> getLikes(@PathVariable String id) {
        return ResponseEntity.ok(Map.of("likes", likeService.countLikes(id)));
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
