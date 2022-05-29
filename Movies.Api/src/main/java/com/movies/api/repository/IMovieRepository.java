package com.movies.api.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.movies.api.entities.Movies;

public interface IMovieRepository extends JpaRepository<Movies, Long>{

}
