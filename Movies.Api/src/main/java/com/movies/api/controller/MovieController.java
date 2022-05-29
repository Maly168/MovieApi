package com.movies.api.controller;

import java.util.List;

import javax.validation.Valid;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movies.api.entities.MovieResponse;
import com.movies.api.entities.Movies;
import com.movies.api.entities.MoviesResponse;
import com.movies.api.entities.ResponseBase;
import com.movies.api.services.IMoviesService;

@RestController
public class MovieController {
	
	@Autowired
	private IMoviesService movieService;
		
	@GetMapping("/getMovies")
	public MoviesResponse GetMovies()
	{
		return this.movieService.GetMovies();
	}
	
	@GetMapping("/movie/{id}")
	public MovieResponse GetMovie(@PathVariable long id)
	{
		return this.movieService.GetMovie(id);
	}
	
	@PostMapping("/createMovie")
	public MovieResponse CreateMovie(@RequestBody Movies movie)
	{
		return this.movieService.AddMovie(movie);
	}
	
	@PutMapping("/updateMovie")
	public MovieResponse UpdateMovie(@Validated @RequestBody Movies movie)
	{
		return this.movieService.UpdateMovie(movie);
	}
	
	@DeleteMapping("/movie/{id}")
	public ResponseBase DeleteMovie(@PathVariable long id)
	{
		return movieService.DeleteMovie(id);
		
	}
}
