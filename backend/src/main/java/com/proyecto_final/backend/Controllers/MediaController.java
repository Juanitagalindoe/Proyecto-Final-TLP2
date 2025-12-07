package com.proyecto_final.backend.Controllers;

import com.proyecto_final.backend.Services.MediaService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/media")
@CrossOrigin(origins = "*")
public class MediaController {

    private final MediaService mediaService;

    public MediaController(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    @GetMapping("/{postId}")
    public ResponseEntity<?> getByPost(@PathVariable String postId) {
        return ResponseEntity.ok(mediaService.getMediaByPost(postId));
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
