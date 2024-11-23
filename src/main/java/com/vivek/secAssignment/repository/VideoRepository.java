package com.vivek.secAssignment.repository;

import com.vivek.secAssignment.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video, Long> {
    List<Video> findByIsAvailableTrue();
}