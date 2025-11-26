package com.proyecto_final.backend.Services;

import com.proyecto_final.backend.Exception.ResourceNotFoundException;
import com.proyecto_final.backend.Models.Entity.Media;
import com.proyecto_final.backend.Models.Entity.Post;
import com.proyecto_final.backend.Models.Repository.MediaRepository;
import com.proyecto_final.backend.Models.Repository.PostRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MediaService {

    private final MediaRepository mediaRepository;
    private final PostRepository postRepository;

    public MediaService(MediaRepository mediaRepository, PostRepository postRepository) {
        this.mediaRepository = mediaRepository;
        this.postRepository = postRepository;
    }

    public Media addMedia(String postId, String url, String tipo) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post no encontrado"));

        Media media = new Media();
        media.setPost(post);
        media.setUrl(url);
        media.setTipo(tipo);

        return mediaRepository.save(media);
    }

    public List<Media> getMediaByPost(String postId) {
        return mediaRepository.findByPostId(postId);
    }
}
