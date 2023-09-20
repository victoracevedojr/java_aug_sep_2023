package com.adrianbarnard.querydemo.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="performers")
public class Performer {
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
        this.updatedAt = new Date(); // Generate timestamp for updatedAt column when adding to DB
    }
    
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    @NotEmpty(message="Please enter a first name")
    @Size(min=2, max=255, message="First name must be 2-255 characters, inclusively")
    private String firstName;
    
    @NotEmpty(message="Please enter a last name")
    @Size(min=2, max=255, message="Last name must be 2-255 characters, inclusively")
    private String lastName;
    
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
    		name="performers_movies", // Name of table
    		joinColumns=@JoinColumn(name="performer_id"), // Foreign key ID for this model
    		inverseJoinColumns=@JoinColumn(name="movie_id") // Foreign key ID for another model
    )
    private List<Movie> performerMovies;
    
    public Performer() {}

	public Performer(
			@NotEmpty(message = "Please enter a first name") @Size(min = 2, max = 255, message = "First name must be 2-255 characters, inclusively") String firstName,
			@NotEmpty(message = "Please enter a last name") @Size(min = 2, max = 255, message = "Last name must be 2-255 characters, inclusively") String lastName,
			List<Movie> performerMovies) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.performerMovies = performerMovies;
	}

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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Movie> getPerformerMovies() {
		return performerMovies;
	}

	public void setPerformerMovies(List<Movie> performerMovies) {
		this.performerMovies = performerMovies;
	}
    
    
}
