package com.movieFlix.moviefliex.controller.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record StreamingRequest(@NotEmpty(message = "Epa! O nome do servico de streaming e obrigatorio.") String name) {
}
