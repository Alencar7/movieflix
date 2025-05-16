package com.movieFlix.moviefliex.service;

import com.movieFlix.moviefliex.entity.Category;
import com.movieFlix.moviefliex.entity.Streaming;
import com.movieFlix.moviefliex.repository.StreamingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StreamingService {

    private final StreamingRepository repository;

    public List<Streaming> findAll() {
        return repository.findAll();
    }

    public Streaming save(Streaming streaming) {
        return repository.save(streaming);
    }

    public Optional<Streaming> findById(Long id){
        return repository.findById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }


}
