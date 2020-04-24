package com.user.management.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.management.model.entity.Profile;
import com.user.management.model.entity.ProfileUser;
import com.user.management.model.entity.User;


public interface IProfileUserDao extends JpaRepository<ProfileUser, Long>{

	public boolean existsByUserAndProfile(User user, Profile profile);
}
