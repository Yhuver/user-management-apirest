package com.user.management.test.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.user.management.test.exception.CustomException;
import com.user.management.test.model.dao.IDependencyDao;
import com.user.management.test.model.entity.Dependency;
import com.user.management.test.service.IDependencyService;

@Service
public class DependencyService implements IDependencyService{

	@Autowired
	private IDependencyDao dependencyDao;
	
	@Override
	public Dependency getDependency(Long idDependency) {
		Optional<Dependency> opt=dependencyDao.findById(idDependency);
		if(opt.isPresent()) {
			return opt.get();
		}
		else {
			throw new CustomException("No se encontro esta dependencia", HttpStatus.NOT_FOUND);
		}
	}

}
