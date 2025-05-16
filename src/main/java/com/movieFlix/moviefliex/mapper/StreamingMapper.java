package com.movieFlix.moviefliex.mapper;

import com.movieFlix.moviefliex.controller.request.StreamingRequest;
import com.movieFlix.moviefliex.controller.response.StreamingResponse;
import com.movieFlix.moviefliex.entity.Streaming;
import lombok.experimental.UtilityClass;

@UtilityClass //lombok
public class StreamingMapper {

    public static Streaming toStreaming(StreamingRequest request) {
        return Streaming
                .builder()
                .name(request.name())
                .build();
    }

    public static StreamingResponse toStreamingResponse(Streaming streaming) {
        return StreamingResponse
                .builder()
                .id(streaming.getId())
                .name(streaming.getName())
                .build();
    }
}