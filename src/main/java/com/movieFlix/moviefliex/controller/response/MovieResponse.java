package com.movieFlix.moviefliex.controller.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record MovieResponse(@Schema(type = "long", description = "Código do filme")
                            Long id,
                            @Schema(type = "string", description = "Nome do filme")
                            String title,
                            @Schema(type = "string", description = "Descrição do filme")
                            String description,
                            @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                            //@Schema(type = "date", description = "Código do filme")
                            LocalDate releseDate,
                            double rating,
                            List<CategoryResponse> categories,
                            List<StreamingResponse> streamings
) {
}
