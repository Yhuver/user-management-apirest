package com.user.management.test.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.management.test.model.entity.Profile;

public interface IProfileDao extends JpaRepository<Profile, Long>{

}