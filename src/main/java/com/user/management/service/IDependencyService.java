package com.user.management.service;

import java.util.List;

import com.user.management.dto.ListDependencyDto;
import com.user.management.model.entity.Dependency;

public interface IDependencyService {

	public List<ListDependencyDto> listDependency();
	
	public Dependency getDependency(Long idDependency);
}
