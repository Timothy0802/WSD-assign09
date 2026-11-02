package org.example.assignment.assign09.dto;

public record MovieRequest(
        String title,
        String author,
        Integer price,
        Integer releaseYear,
        String genre
) {
}
