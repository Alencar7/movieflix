package com.movieFlix.moviefliex.controller;

import com.movieFlix.moviefliex.controller.request.CategoryRequest;
import com.movieFlix.moviefliex.controller.response.CategoryResponse;
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

@Tag(name = "Category", description = "Recurso responsavel pelos gerenciamentos das categorias.")
public interface CategoryController {

    //annotation
    @Operation(summary = "Salvar categoria", description = "Método responsável por realizar o salvamento de uma nova categoria.",
            security = @SecurityRequirement(name = "bearerAuth")) //security
    @ApiResponse(responseCode = "201", description = "Categoria salva com sucesso",
            content = @Content(schema = @Schema(implementation = CategoryResponse.class)))
    ResponseEntity<CategoryResponse> saveCategory(@Valid @RequestBody CategoryRequest request);

    @Operation(summary = "Buscar categorias", description = "Método responsável por buscar categorias.",
            security = @SecurityRequirement(name = "bearerAuth")) //security*bearerAuth
    @ApiResponse(responseCode = "200", description = "Categorias encontradas com sucesso",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = CategoryResponse.class))))
    ResponseEntity<List<CategoryResponse>> getAllCategories();


    @Operation(summary = "Buscar categoria por ID", description = "Método responsável por buscar categoria por ID.",
            security = @SecurityRequirement(name = "bearerAuth")) //security*bearerAuth
    @ApiResponse(responseCode = "200", description = "Categoria encontrada com sucesso",
            content = @Content(schema = @Schema(implementation = CategoryResponse.class)))
    @ApiResponse(responseCode = "404", description = "Categoria nao encontrada",
            content = @Content())
    ResponseEntity<CategoryResponse> getByCategoryId(@PathVariable Long id);

    @Operation(summary = "Deletar categoria por ID", description = "Método responsável por deletar categoria por ID.",
            security = @SecurityRequirement(name = "bearerAuth")) //security*bearerAuth
    @ApiResponse(responseCode = "204", description = "Categoria deletada com sucesso", content = @Content())
    @ApiResponse(responseCode = "404", description = "Categoria nao encontrada", content = @Content())
    ResponseEntity<Void> deleteByCategoryId(@PathVariable Long id);
}
