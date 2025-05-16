package com.movieFlix.moviefliex.service;

import com.movieFlix.moviefliex.config.JWTUserData;
import com.movieFlix.moviefliex.entity.Category;
import com.movieFlix.moviefliex.entity.Movie;
import com.movieFlix.moviefliex.entity.Streaming;
import com.movieFlix.moviefliex.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    private final CategoryService categoryService;
    private final StreamingService streamingService;

    //salvar
    public Movie save(Movie movie) {
        //settar o retorno do categoriesFound
        movie.setCategories((this.findCategories(movie.getCategories())));
        movie.setStreamings((this.findStreamings(movie.getStreamings())));
        return movieRepository.save(movie);
    }

    //listar todos
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    //listar por categoria
    public List<Movie> findByCategory(Long categoryId) {
        return movieRepository.findMovieByCategories(List.of(Category.builder().id(categoryId).build()));
    }

    //listar id
    public Optional<Movie> findById(Long id) {
        return movieRepository.findById(id);
    }

    //atualizar
    public Optional<Movie> update(Long moveId, Movie updateMovie) {
        Optional<Movie> optionalMovie = movieRepository.findById(moveId);
        if (optionalMovie.isPresent()) {

            List<Category> categories = this.findCategories(updateMovie.getCategories());
            List<Streaming> streamings = this.findStreamings(updateMovie.getStreamings());

            Movie movie = optionalMovie.get();

            movie.setTitle(updateMovie.getTitle());
            movie.setDescription(updateMovie.getDescription());
            movie.setRelesaeDate(updateMovie.getRelesaeDate());
            movie.setRating(updateMovie.getRating());

            movie.getCategories().clear();
            movie.getCategories().addAll(categories);

            movie.getStreamings().clear();
            movie.getStreamings().addAll(streamings);

            movieRepository.save(movie);

            return Optional.of(movie);

        }
        return Optional.empty();

    }

    public void delete(Long movieId) {
        movieRepository.deleteById(movieId);
    }

    //garantir que os id`s existam
    private List<Category> findCategories(List<Category> categories) {
        List<Category> categoriesFound = new ArrayList<>();
        categories.forEach(category -> categoryService.findById(category.getId()).ifPresent(categoriesFound::add));
        return categoriesFound;
    }

    private List<Streaming> findStreamings(List<Streaming> streamings) {
        List<Streaming> streamingsFound = new ArrayList<>();
        streamings.forEach(streaming -> streamingService.findById(streaming.getId()).ifPresent(streamingsFound::add));
        return streamingsFound;
    }


}
