package com.user.management.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.management.model.entity.TaskUser;

public interface ITaskUserDao extends JpaRepository<TaskUser, Long>{

}
