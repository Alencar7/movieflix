package com.movieFlix.moviefliex.controller;

import com.movieFlix.moviefliex.controller.request.StreamingRequest;
import com.movieFlix.moviefliex.controller.response.MovieResponse;
import com.movieFlix.moviefliex.controller.response.StreamingResponse;
import com.movieFlix.moviefliex.entity.Streaming;
import com.movieFlix.moviefliex.mapper.StreamingMapper;
import com.movieFlix.moviefliex.service.StreamingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieflix/streaming")
@RequiredArgsConstructor
//@Tag(name = "Streaming", description = "")
public class StreamingController {

    private final StreamingService streamingService;

//    //annotations
//    @Operation(summary = "Salvar filme", description = "Método responsável por realizar o salvamento de um novo filme.")
//    @ApiResponse(responseCode = "201", description = "Filme salvo com sucesso",
//            content = @Content(schema = @Schema(implementation = MovieResponse.class)))
//    @PostMapping
    @GetMapping
    public ResponseEntity<List<StreamingResponse>> getAll() {
        List<StreamingResponse> streamings = streamingService.findAll()
                .stream()
                .map(StreamingMapper::toStreamingResponse)
                .toList();

        return ResponseEntity.ok(streamings);
    }

    @PostMapping
    public ResponseEntity<StreamingResponse> save(@Valid @RequestBody StreamingRequest request) {
        Streaming savedStreaming = streamingService.save(StreamingMapper.toStreaming(request));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(StreamingMapper.toStreamingResponse(savedStreaming));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StreamingResponse> getById(@PathVariable Long id) {
        return streamingService.findById(id)
                .map(streaming -> ResponseEntity.ok(StreamingMapper.toStreamingResponse(streaming)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        streamingService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
