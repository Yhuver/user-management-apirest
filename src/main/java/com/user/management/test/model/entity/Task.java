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
@Table(name = "tasks")
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "task_id")
	private Long id;
	
	@Column(name = "task_status")
	private Boolean status;

	@Column(name = "task_duration")
	private Integer duration;
	
	@Column(name = "task_name")
	private String name;
	
	@Column(name = "task_description")
	private String description;

}
