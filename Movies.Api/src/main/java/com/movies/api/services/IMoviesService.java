package com.movies.api.services;

import java.util.List;

import com.movies.api.entities.MovieResponse;
import com.movies.api.entities.Movies;
import com.movies.api.entities.MoviesResponse;
import com.movies.api.entities.ResponseBase;

public interface IMoviesService {
	public MoviesResponse GetMovies();
	public MovieResponse GetMovie(long id);
	public MovieResponse AddMovie(Movies movie);
	public MovieResponse UpdateMovie(Movies movie);
	public ResponseBase DeleteMovie(long id);
}
