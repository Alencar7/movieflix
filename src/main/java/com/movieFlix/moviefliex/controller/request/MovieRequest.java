package com.movieFlix.moviefliex.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;
import java.util.List;

public record MovieRequest(@Schema(type = "string", description = "Nome do filme")
                           @NotEmpty(message = "Ops... O titulo do filme e obrigatorio.")
                           String title,
                           @Schema(type = "string", description = "Descrição do filme.")
                           String description,
                           @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                           @Schema(type = "date", description = "Data de lançamento do filme.")
                           LocalDate releseDate,
                           @Schema(type = "double", description = "Score do filme.")
                           double rating,
                           @Schema(type = "array", description = "Lista de códigos de categoria.")
                           List<Long> categories,
                           @Schema(type = "array", description = "Lista de códigos de streamings.")
                           List<Long> streamings
) {
}
