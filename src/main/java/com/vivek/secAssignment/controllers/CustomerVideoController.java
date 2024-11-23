package com.vivek.secAssignment.controllers;

import com.vivek.secAssignment.model.Video;
import com.vivek.secAssignment.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customer/videos")
public class CustomerVideoController {

    @Autowired
    private VideoRepository videoRepository;

    @GetMapping
    public List<Video> getAvailableVideos() {
        return videoRepository.findByIsAvailableTrue();
    }
}
