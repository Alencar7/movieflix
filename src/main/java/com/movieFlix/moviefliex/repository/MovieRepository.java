package com.movieFlix.moviefliex.repository;

import com.movieFlix.moviefliex.entity.Category;
import com.movieFlix.moviefliex.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    //procurar os filmes por categorias
    List<Movie> findMovieByCategories(List<Category> categories);

//    List<Movie> findTop5ByRatingDesc(); desisti
}
