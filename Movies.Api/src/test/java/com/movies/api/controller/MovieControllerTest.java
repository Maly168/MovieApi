package com.movies.api.controller;

//import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.movies.api.entities.Movies;
import com.movies.api.repository.IMovieRepository;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;


@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)


public class MovieControllerTest {

	@Autowired
	 private TestEntityManager entityManager;

	@Autowired
	private IMovieRepository movieRepository;
	@Test
	public void getMovies() {
		//given
	       Movies firstMovie = new Movies(6, "test4", 2, 4);
	       entityManager.persist(firstMovie);
	       entityManager.flush();

	       Movies secondMovie = new Movies(10, "test5", 2, 4);
	       entityManager.persist(secondMovie);
	       entityManager.flush();

	       //when
	       List<Movies> movies = movieRepository.findAll();

	       //then
	       assertThat(movies.contains(firstMovie));
	       assertThat(movies.contains(secondMovie));
	}
	
   @Test
   public void GetSingleMovie() {
       //given
	   Movies movie = new Movies(11, "test5", 2, 4);
       entityManager.persist(movie);
       entityManager.flush();

       //when
       Movies testMovie = movieRepository.getOne(movie.Id);

       //then
       assertThat(testMovie.Id).isEqualTo(movie.Id);
   }
   
   @Test
   public void CreateMovie() {
       //given
	   Movies movie = new Movies(12, "test6", 2, 4);
       entityManager.persist(movie);
       entityManager.flush();

       //when
       Movies testMovie = movieRepository.save(movie);

       //then
       assertThat(testMovie.Id).isEqualTo(movie.Id);
       assertThat(testMovie.Title).isEqualTo(movie.Title);
       assertThat(testMovie.Category).isEqualTo(movie.Category);
       assertThat(testMovie.Rating).isEqualTo(movie.Rating);
   }
   
   @Test
   public void UpdateMovie() {
       //given
	   Movies movie = new Movies(12, "test7", 2, 4);
       entityManager.persist(movie);
       entityManager.flush();

       //when
       Movies testMovie = movieRepository.save(movie);

       //then
       assertThat(testMovie.Id).isEqualTo(movie.Id);
       assertThat(testMovie.Title).isEqualTo(movie.Title);
   }
   
   @Test
   public void DeleteMovie() {
       //given
	   Movies movie = new Movies(12, "test7", 2, 4);
       entityManager.persist(movie);
       entityManager.flush();

       //when
        movieRepository.delete(movie);

        List<Movies> movies = movieRepository.findAll();
       //then
        assertThat(!movies.contains(movie));
   }

}
