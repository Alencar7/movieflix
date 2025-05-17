package com.movieFlix.moviefliex.controller;

import com.movieFlix.moviefliex.controller.request.MovieRequest;
import com.movieFlix.moviefliex.controller.response.MovieResponse;
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

@Tag(name = "Movie", description = "Recurso responsavel pelos gerenciamentos dos filmes.")
public interface MovieController {

    //annotation
    @Operation(summary = "Salvar filme", description = "Método responsável por realizar o salvamento de um novo filme.",
            security = @SecurityRequirement(name = "bearerAuth")) //security
    @ApiResponse(responseCode = "201", description = "Filme salvo com sucesso",
            content = @Content(schema = @Schema(implementation = MovieResponse.class)))
    ResponseEntity<MovieResponse> save(@Valid @RequestBody MovieRequest request);

    @Operation(summary = "Buscar filmes", description = "Método responsável por retornar todos os filmes cadastrados.",
            security = @SecurityRequirement(name = "bearerAuth")) //security*bearerAuth
    @ApiResponse(responseCode = "200", description = "Retorna todos os filmes cadastrados",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = MovieResponse.class))))
    ResponseEntity<List<MovieResponse>> findAll();

    @Operation(summary = "Buscar filme por ID", description = "Método responsável por buscar filme por ID.",
            security = @SecurityRequirement(name = "bearerAuth")) //security*bearerAuth
    @ApiResponse(responseCode = "200", description = "Filme encontrado com sucesso",
            content = @Content(schema = @Schema(implementation = MovieResponse.class)))
    @ApiResponse(responseCode = "404", description = "Filme nao encontrado",
            content = @Content())
    ResponseEntity<MovieResponse> findById(@PathVariable Long id);

    @Operation(summary = "Alterar filme", description = "Método responsável por alterar/editar dados do filme.",
            security = @SecurityRequirement(name = "bearerAuth")) //security*bearerAuth
    @ApiResponse(responseCode = "200", description = "Filme alterado com sucesso",
            content = @Content(schema = @Schema(implementation = MovieResponse.class)))
    @ApiResponse(responseCode = "404", description = "Filme nao encontrado",
            content = @Content())
    ResponseEntity<MovieResponse> update(@PathVariable Long id,@Valid @RequestBody MovieRequest request);

    @Operation(summary = "Buscar filmes por categoria", description = "Método responsável por buscar categorias de filmes.",
            security = @SecurityRequirement(name = "bearerAuth")) //security*bearerAuth
    @ApiResponse(responseCode = "200", description = "Filmes encontrados com sucesso",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = MovieResponse.class))))
    ResponseEntity<List<MovieResponse>> findByCategory(@RequestParam Long category);

    @Operation(summary = "Deletar filme por ID", description = "Método responsável por deletar filme por ID.",
            security = @SecurityRequirement(name = "bearerAuth")) //security*bearerAuth
    @ApiResponse(responseCode = "204", description = "Filme deletado com sucesso", content = @Content())
    @ApiResponse(responseCode = "404", description = "Filme nao encontrado", content = @Content())
    ResponseEntity<Void> delete(@PathVariable Long id);





}
