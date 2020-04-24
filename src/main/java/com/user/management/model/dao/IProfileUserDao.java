package com.user.management.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.management.model.entity.ProfileUser;


public interface IProfileUserDao extends JpaRepository<ProfileUser, Long>{

}
