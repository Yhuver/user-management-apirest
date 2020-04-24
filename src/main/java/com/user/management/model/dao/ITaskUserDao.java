package com.user.management.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.management.model.entity.Task;
import com.user.management.model.entity.TaskUser;
import com.user.management.model.entity.User;

public interface ITaskUserDao extends JpaRepository<TaskUser, Long>{

	public boolean existsByUserAndTask(User user, Task task);
}
