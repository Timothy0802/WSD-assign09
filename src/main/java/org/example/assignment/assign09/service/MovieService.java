package org.example.assignment.assign09.service;

import org.example.assignment.assign09.dto.*;
import org.example.assignment.assign09.entity.Movie;
import org.example.assignment.assign09.repository.MovieRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

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

    public List<MovieResponse> findAll() {
        List<Movie> movies = repository.findAll();
        List<MovieResponse> movieResponses = new ArrayList<>();

        for (Movie movie : movies) {
            movieResponses.add(MovieResponse.from(movie));
        }
        return movieResponses;
    }

    public MovieResponse findById(Long id) {
        return MovieResponse.from(findEntity(id));
    }

    public MovieResponse update(MovieRequest request, Long id) {
        Movie movie = findEntity(id);
        movie.update(request);
        return MovieResponse.from(repository.save(movie));
    }

    public void delete(Long id) {
        if(!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found: " + id);
        }
        repository.deleteById(id);
    }

    private Movie findEntity(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found: " + id));
    }
}
