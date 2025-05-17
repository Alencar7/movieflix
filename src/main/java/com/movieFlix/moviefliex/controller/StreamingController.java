package com.movieFlix.moviefliex.controller;

import com.movieFlix.moviefliex.controller.request.StreamingRequest;
import com.movieFlix.moviefliex.controller.response.CategoryResponse;
import com.movieFlix.moviefliex.controller.response.StreamingResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Streaming", description = "Recurso responsavel pelo gerenciamento da streaming.")
public interface StreamingController {

    //annotation
    @Operation(summary = "Salvar streamings", description = "Método responsável por realizar o salvamento de uma nova streaming.",
            security = @SecurityRequirement(name = "bearerAuth")) //security
    @ApiResponse(responseCode = "201", description = "Streaming salva com sucesso",
            content = @Content(schema = @Schema(implementation = StreamingResponse.class)))
    ResponseEntity<StreamingResponse> save(@Valid @RequestBody StreamingRequest request);

    @Operation(summary = "Buscar streamings", description = "Método responsável por buscar streamings.",
            security = @SecurityRequirement(name = "bearerAuth")) //security*bearerAuth
    @ApiResponse(responseCode = "200", description = "Streamings encontradas com sucesso",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = StreamingResponse.class))))
    ResponseEntity<List<StreamingResponse>> getAll();

    @Operation(summary = "Buscar streaming por ID", description = "Método responsável por buscar streamings por ID.",
            security = @SecurityRequirement(name = "bearerAuth")) //security*bearerAuth
    @ApiResponse(responseCode = "200", description = "Streaming encontrada com sucesso",
            content = @Content(schema = @Schema(implementation = StreamingResponse.class)))
    @ApiResponse(responseCode = "404", description = "Streaming nao encontrada",
            content = @Content())
    ResponseEntity<StreamingResponse> getById(@PathVariable Long id);

    @Operation(summary = "Deletar streaming por ID", description = "Método responsável por deletar streaming por ID.",
            security = @SecurityRequirement(name = "bearerAuth")) //security*bearerAuth
    @ApiResponse(responseCode = "204", description = "Streaming deletada com sucesso", content = @Content())
    @ApiResponse(responseCode = "404", description = "Streaming nao encontrada", content = @Content())
    ResponseEntity<Void> deleteById(@PathVariable Long id);

}
