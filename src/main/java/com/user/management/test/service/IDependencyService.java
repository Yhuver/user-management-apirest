package com.user.management.test.service;

import java.util.List;

import com.user.management.test.dto.ListDependencyDto;
import com.user.management.test.model.entity.Dependency;

public interface IDependencyService {

	public List<ListDependencyDto> listDependency();
	
	public Dependency getDependency(Long idDependency);
}
