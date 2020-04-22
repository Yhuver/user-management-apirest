package com.user.management.test.model.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;
	
	@Column(name = "user_status")
	private Boolean status;
	
	@Column(name = "user_birth_date")
	private LocalDate birthDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "depe_id")
	private Dependency dependency;
	
	@Column(name = "user_name")
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "user")
	private List<TaskUser> taskUser;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "user")
	private List<ProfileUser> profileUser;
}
