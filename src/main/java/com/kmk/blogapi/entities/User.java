package com.kmk.blogapi.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Setter
@Getter
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
	@Column(name = "user_id")
	private int id;	
	
	@Column(name = "user_name", nullable = false, length = 20)
	private String name;
	
	@Column(name = "user_email", nullable = false, length = 20)
	private String email;
	
	@Column(nullable = false, length = 20)
	private String password;
	
	@Column(nullable = true, length = 50)
	private String about;
}
