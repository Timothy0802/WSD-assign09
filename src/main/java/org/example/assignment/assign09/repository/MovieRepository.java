package org.example.assignment.assign09.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.assignment.assign09.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
