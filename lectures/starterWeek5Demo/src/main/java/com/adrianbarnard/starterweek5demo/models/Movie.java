package com.adrianbarnard.starterweek5demo.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    // other getters and setters removed for brevity
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
        this.updatedAt = new Date(); // NEW: To generate timestamp for updatedAt column when adding to DB
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    // Columns we're adding ourselves for this specific model
    
    // Title, rating, genre, release year, description
    @NotNull(message="Title cannot be empty")
    @Size(min=1, max=255, message="Title must be 1 to 255 characters")
    private String title;
    
    @NotNull(message="Rating must be selected")
    private String rating;
    
    @NotNull(message="Genre must be entered")
    @Size(min=3, max=255, message="Genre must be 3 to 255 characters")
    private String genre;
    
    @NotNull(message="Please enter a release year")
    @Min(value=1890, message="Release year must be 1890 or later") // Also @Max() is used for Integers
    private Integer releaseYear; // Do NOT use primitive types!!! So use Integer instead of int
    
    @NotNull(message="Description must be entered")
    @Size(min=5, message="Description must be 5 or more characters")
    @Column(columnDefinition="TEXT") // Making this a text field
    private String description;

    // Constructors - the empty one was added myself
    public Movie() {
    	
    }
    
    // For this constructor, don't include id, createdAt or updatedAt
	public Movie(
			@NotNull(message = "Title cannot be empty") @Size(min = 1, max = 255, message = "Title must be 1 to 255 characters") String title,
			@NotNull(message = "Rating must be selected") String rating,
			@NotNull(message = "Genre must be entered") @Size(min = 3, max = 255, message = "Genre must be 3 to 255 characters") String genre,
			@NotNull(message = "Please enter a release year") @Min(value = 1890, message = "Release year must be 1890 or later") Integer releaseYear,
			@NotNull(message = "Description must be entered") @Size(min = 5, message = "Description must be 5 or more characters") String description) {
		this.title = title;
		this.rating = rating;
		this.genre = genre;
		this.releaseYear = releaseYear;
		this.description = description;
	}
	
	// Getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Integer getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
    
    
}
