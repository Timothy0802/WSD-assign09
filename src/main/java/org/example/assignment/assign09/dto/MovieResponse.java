package org.example.assignment.assign09.dto;

public record MovieResponse(
        Long id,
        String title,
        String author,
        Integer price,
        Integer releaseYear,
        String genre
) {
}