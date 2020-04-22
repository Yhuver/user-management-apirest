package com.user.management.test.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.management.test.model.entity.User;

public interface IUserDao extends JpaRepository<User, Long>{

	public boolean existsByName(String name);
}
