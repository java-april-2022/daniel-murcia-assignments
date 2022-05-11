package com.dm.arbortrary.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name="trees")
public class Tree {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Species is required.")
	@Size(min=2, max=200)
	private String species;
	
	@NotEmpty(message="Location is required!")
	@Size(min=2, max= 1000)
	private String location;
	
	@NotEmpty(message="Reason is required!")
	@Size(min=2, max= 1000)
	private String reason;

	@NotEmpty(message="Date Planted is required!")
	@Size(min=2, max= 1000)
	private String datePlanted;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "visits", 
			joinColumns = @JoinColumn(name= "tree_id"), 
			inverseJoinColumns = @JoinColumn(name = "user_id")
		)
	private List<User> visitors;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getDatePlanted() {
		return datePlanted;
	}

	public void setDatePlanted(String datePlanted) {
		this.datePlanted = datePlanted;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getVisitors() {
		return visitors;
	}

	public void setVisitors(List<User> visitors) {
		this.visitors = visitors;
	}
	

}
