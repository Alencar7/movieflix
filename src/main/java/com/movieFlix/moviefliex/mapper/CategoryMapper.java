package com.movieFlix.moviefliex.mapper;

import com.movieFlix.moviefliex.controller.request.CategoryRequest;
import com.movieFlix.moviefliex.controller.response.CategoryResponse;
import com.movieFlix.moviefliex.entity.Category;
import lombok.experimental.UtilityClass;

@UtilityClass //lombok
public class CategoryMapper {

    public static Category toCategory(CategoryRequest categoryRequest) {
        return Category
                .builder()
                .name(categoryRequest.name())
                .build();
    }

    public static CategoryResponse toCategoryResponse(Category category) {
        return CategoryResponse
                .builder()
                .id(category.getId())
                .name(category.getName())
                .build();

    }

}
