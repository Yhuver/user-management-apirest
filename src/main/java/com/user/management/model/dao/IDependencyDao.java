package com.user.management.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.management.model.entity.Dependency;

public interface IDependencyDao extends JpaRepository<Dependency, Long>{

}
