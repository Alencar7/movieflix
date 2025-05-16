package com.movieFlix.moviefliex.repository;

import com.movieFlix.moviefliex.entity.Streaming;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreamingRepository extends JpaRepository<Streaming, Long> {
}
