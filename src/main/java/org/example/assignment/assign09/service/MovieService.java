package org.example.assignment.assign09.service;

import org.example.assignment.assign09.dto.*;
import org.example.assignment.assign09.entity.Movie;
import org.example.assignment.assign09.repository.MovieRepository;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    private MovieRepository repository;

    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public MovieResponse create(MovieRequest request) {
        Movie saved = repository.save(new Movie(request));
        return MovieResponse.from(saved);
    }
}
