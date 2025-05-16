package com.movieFlix.moviefliex.controller.request;

import jakarta.validation.constraints.NotEmpty;

public record CategoryRequest(@NotEmpty(message = "Epa! O ome da categoria e obrigatorio.") String name) {
}
