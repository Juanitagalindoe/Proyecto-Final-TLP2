package com.proyecto_final.backend.Controllers;

import com.proyecto_final.backend.DTO.CreateCommentDTO;
import com.proyecto_final.backend.Models.Entity.Comment;
import com.proyecto_final.backend.Services.CommentService;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
@CrossOrigin(origins = "*")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<Comment> create(@Valid @RequestBody CreateCommentDTO dto) {
        return ResponseEntity.ok(commentService.create(dto));
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<?> getByPost(@PathVariable String postId) {
        return ResponseEntity.ok(commentService.getByPost(postId));
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
