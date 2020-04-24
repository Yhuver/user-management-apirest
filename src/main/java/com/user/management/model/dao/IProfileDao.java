package com.user.management.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.management.model.entity.Profile;

public interface IProfileDao extends JpaRepository<Profile, Long>{

}
