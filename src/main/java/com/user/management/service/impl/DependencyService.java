package com.user.management.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.user.management.dto.ListDependencyDto;
import com.user.management.exception.CustomException;
import com.user.management.model.dao.IDependencyDao;
import com.user.management.model.entity.Dependency;
import com.user.management.service.IDependencyService;

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

	@Override
	public List<ListDependencyDto> listDependency() {
		List<Dependency> list=dependencyDao.findAll();
		List<ListDependencyDto> listResult=new ArrayList<>();
		for (Dependency dependency : list) {
			listResult.add(ListDependencyDto.builder().
					idDependency(dependency.getId()).
					nameDependency(dependency.getName()).build());
		}
		
		return listResult;
	}

}
