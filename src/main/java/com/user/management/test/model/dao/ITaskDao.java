package com.user.management.test.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.management.test.model.entity.Task;

public interface ITaskDao extends JpaRepository<Task, Long>{

}
