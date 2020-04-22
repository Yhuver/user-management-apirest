package com.user.management.test.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.management.test.model.entity.Dependency;

public interface IDependencyDao extends JpaRepository<Dependency, Long>{

}
