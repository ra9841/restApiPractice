package com.example.restApiDay1.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="userloginInfo")
public class LoginEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	@NotNull
	@Size(min=2)
	//@Column(unique = true)
	private String username;
	@NotNull
	@Size(max=5)
	private String password;
	private String roll;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRoll() {
		return roll;
	}
	public void setRoll(String roll) {
		this.roll = roll;
	}
	
	
	

}
