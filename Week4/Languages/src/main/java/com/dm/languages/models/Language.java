package com.dm.languages.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="languages")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	@NotBlank
	@Size(min=2, max=20, message="Name must be at least 2 characters.")
    private String name;
	
	@NotBlank
	@Size(min=2, max=20, message="Creator must be at least 2 characters.")
    private String creator;
	
	@NotNull (message="Version cannot be blank.")
    private Double version;
	

  
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    
    
	public Language() {
	}



	public Language(Long id,
			@NotBlank @Size(min = 2, max = 200, message = "Name must be at least 2 characters.") String name,
			@NotBlank @Size(min = 2, max = 200, message = "Vendor must be at least two characters.") String creator,
			@NotNull(message = "Amount cannot be blank.") @Min(value = 1, message = "Amount must be at least $1.") Double version,
			Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.creator = creator;
		this.version = version;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getCreator() {
		return creator;
	}



	public void setCreator(String creator) {
		this.creator = creator;
	}



	public Double getVersion() {
		return version;
	}



	public void setVersion(Double version) {
		this.version = version;
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
        
	
	
    
    
}
