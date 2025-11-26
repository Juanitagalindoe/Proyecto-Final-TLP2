package com.proyecto_final.backend.Controllers;

import com.proyecto_final.backend.Models.Entity.Media;
import com.proyecto_final.backend.Services.MediaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/media")
@CrossOrigin("*")
public class MediaController {

    private final MediaService mediaService;

    public MediaController(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    @GetMapping("/{postId}")
    public List<Media> getByPost(@PathVariable String postId) {
        return mediaService.getMediaByPost(postId);
    }
}