package org.example.assignment.assign09.entity;

import jakarta.persistence.*;
import org.example.assignment.assign09.dto.MovieRequest;

@Entity(name = "movies")
@Table(name = "movie_sql")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(nullable =false, length = 100)
    private String author;

    @Column(nullable = false)
    private Integer price;

    private Integer releaseYear;

    @Column(nullable = false, length = 50)
    private String genre;

    public Movie(MovieRequest request) {
        this.title = request.title();
        this.author = request.author();
        this.price = request.price();
        this.releaseYear = request.releaseYear();
        this.genre = request.genre();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public String getGenre() {
        return genre;
    }
}
