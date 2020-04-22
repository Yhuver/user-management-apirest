package com.user.management.test.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.management.test.model.entity.TaskUser;

public interface ITaskUserDao extends JpaRepository<TaskUser, Long>{

}
