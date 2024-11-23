package com.vivek.secAssignment.repository;

import com.vivek.secAssignment.model.AppUser;
import com.vivek.secAssignment.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByEmail(String email);
}
