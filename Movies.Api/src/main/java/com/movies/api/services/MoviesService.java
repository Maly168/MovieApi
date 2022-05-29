package com.movies.api.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.movies.api.entities.MovieResponse;
import com.movies.api.entities.Movies;
import com.movies.api.entities.MoviesResponse;
import com.movies.api.entities.ResponseBase;
import com.movies.api.repository.IMovieRepository;

@Service
public class MoviesService implements IMoviesService {

	@Autowired
	private IMovieRepository movieRepository; 
	
	@Override
	public MoviesResponse GetMovies() {
		
		MoviesResponse response = new MoviesResponse();
		response.Status = HttpStatus.OK;
		response.Message = "Success";
		response.Data = movieRepository.findAll();
		
		return response;
	}

	@Override
	public MovieResponse GetMovie(long id) {
		Movies m = null;
		MovieResponse response = new MovieResponse();
		for(Movies movie:movieRepository.findAll())
		{
			if(movie.Id == id)
			{
				response.Status = HttpStatus.OK;
				response.Message = "Succes";
				response.Data = movie;
				return response;
			}
		}
		response.Status = HttpStatus.BAD_REQUEST;
		return response;
		//return movieRepository.getOne(id);
		//Movies movie = movieRepository.getReferenceById(id);
		//return movie;
	}

	@Override
	public MovieResponse AddMovie(Movies movie) {
		
		MovieResponse response = new MovieResponse();
		if(movieRepository.existsById(movie.Id))
		{
			response.Status = HttpStatus.BAD_REQUEST;
			response.Message = "Fail to create movie.";
			return response;
			
		}
		
		movieRepository.save(movie);
		response.Status = HttpStatus.OK;
		response.Message = "Success";
		response.Data = movie;
		return response;
	}

	@Override
	public MovieResponse UpdateMovie(Movies movie) {
		MovieResponse response = new MovieResponse();
		if(movieRepository.existsById(movie.Id))
		{
			movieRepository.save(movie);
			response.Status = HttpStatus.OK;
			response.Message = "Success";
			response.Data = movie;
			return response;
		}
		response.Status = HttpStatus.BAD_REQUEST;
		
		return response;
	}

	@Override
	public ResponseBase DeleteMovie(long id) {
		ResponseBase response = new ResponseBase();
		
		if(movieRepository.existsById(id) == false)
		{
			response.Status = HttpStatus.BAD_REQUEST;
			return response;
		}
		Movies movie = movieRepository.getOne(id);
		movieRepository.delete(movie);
		response.Status = HttpStatus.OK;
		response.Message = "Success";
		return response;
		
		
	}
	

}
