package com.user.management.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.management.model.entity.User;

public interface IUserDao extends JpaRepository<User, Long>{

	public boolean existsByName(String name);
}
