package com.vivek.secAssignment.controllers;

import com.vivek.secAssignment.model.Video;
import com.vivek.secAssignment.repository.VideoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/videos")
public class AdminVideoController {

    @Autowired
    private VideoRepository videoRepository;

    @PostMapping
    public Video addVideo(@RequestBody @Valid Video video) {
        return videoRepository.save(video);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Video> updateVideo(@PathVariable Long id, @RequestBody Video updatedVideo) {
        Video video = videoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Video not found"));
        video.setTitle(updatedVideo.getTitle());
        video.setDirector(updatedVideo.getDirector());
        video.setGenre(updatedVideo.getGenre());
        video.setAvailable(updatedVideo.isAvailable());

        return ResponseEntity.ok(videoRepository.save(video));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVideo(@PathVariable Long id) {
        videoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
