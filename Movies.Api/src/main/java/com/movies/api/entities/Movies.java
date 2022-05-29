package com.movies.api.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Movies {
	
	@Id
	public long Id;
	public String Title;
	public int Category;
	public double Rating;
	
	public Movies(long id, String title, int category, double rating) {
		super();
		Id = id;
		Title = title;
		Category = category;
		Rating = rating;
	}
	
	
	public Movies() {
		super();
		// TODO Auto-generated constructor stub
	}



	
}
