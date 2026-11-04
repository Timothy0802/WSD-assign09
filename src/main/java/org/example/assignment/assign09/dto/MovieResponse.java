package org.example.assignment.assign09.dto;

import org.example.assignment.assign09.entity.Movie;

public record MovieResponse(
        Long id,
        String title,
        String author,
        Integer price,
        Integer releaseYear,
        String genre
) {
    public static MovieResponse from(Movie movie) {
        return new MovieResponse(movie.getId(), movie.getTitle(), movie.getAuthor(), movie.getPrice(), movie.getReleaseYear(), movie.getGenre());
    }
}