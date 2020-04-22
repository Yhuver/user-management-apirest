package com.user.management.test.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "dependencies")
public class Dependency {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "depe_id")
	private Long id;
	
	@Column(name = "depe_name")
	private String name;
	
	@Column(name = "depe_description")
	private String description;
	
}
