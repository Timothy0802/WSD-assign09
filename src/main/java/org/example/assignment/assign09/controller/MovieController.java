package org.example.assignment.assign09.controller;

import org.example.assignment.assign09.dto.*;
import org.example.assignment.assign09.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    private MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<MovieResponse> create(
            @RequestBody MovieRequest request) {
        MovieResponse created = service.create(request);
        return ResponseEntity.created(URI.create("/api/movies/" + created.id())).body(created);
    }

    @GetMapping
    public List<MovieResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public MovieResponse findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public MovieResponse update(@PathVariable Long id, @RequestBody MovieRequest request) {
        return service.update(request, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
