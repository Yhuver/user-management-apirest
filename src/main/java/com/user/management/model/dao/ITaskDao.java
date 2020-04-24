package com.user.management.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.management.model.entity.Task;

public interface ITaskDao extends JpaRepository<Task, Long>{

	public boolean existsByName(String name);
}
