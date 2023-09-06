package com.adrianbarnard.week6demo.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity // This is an actual table (or entity)
@Table(name="directors") // Used to name the table in our schema
public class Director {
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
    
    @NotNull(message="Please enter a first name")
    @Size(min=2, max=255, message="First name must be 2 to 255 characters")
    private String firstName;
    
    @NotNull(message="Please enter a last name")
    @Size(min=2, max=255, message="Last name must be 2 to 255 characters")
    private String lastName;

    /* 
     * Added additional fields - including a birthdate field - in our model in Tuesday's lecture!
     * Don't forget getters and setters and updating the constructor as well!
     */
    
    @OneToMany(mappedBy="movieDirector", fetch=FetchType.LAZY)
    private List<Movie> movies;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthdate;
    
    @Transient // Field that will NOT be saved in the database
    private String fullName;
    
    @PostLoad // NOT on platform: After we grab from DB, call on this method to get the value for the full name, derived from first and last names
    protected void onLoad() {
    	this.fullName = this.firstName + " " + this.lastName;
    }
    
    
    public Director() { // Need zero-argument constructor per Java Bean conventions
    	
    }
    
	public Director(
			@NotNull(message = "Please enter a first name") @Size(min = 2, max = 255, message = "First name must be 2 to 255 characters") String firstName,
			@NotNull(message = "Please enter a last name") @Size(min = 2, max = 255, message = "Last name must be 2 to 255 characters") String lastName,
			List<Movie> movies, Date birthdate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.movies = movies;
		this.birthdate = birthdate;
	}
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
    

    
}
