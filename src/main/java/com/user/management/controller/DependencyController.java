package com.user.management.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.management.dto.ApiResponseDto;
import com.user.management.dto.ListDependencyDto;
import com.user.management.service.IDependencyService;
import com.user.management.util.EndponitUtil;

@CrossOrigin("*")
@RestController
@RequestMapping(EndponitUtil.PATH_DEPENDENCY)
public class DependencyController {
	
	private static final Logger LOGGER = LogManager.getLogger(DependencyController.class);
	
	@Autowired
	private IDependencyService dependencyService;
	
	@GetMapping()
	public ApiResponseDto<List<ListDependencyDto>> listDependency(){
		LOGGER.info("Request Dependency :\n" +"listDependency" );
		
		return ApiResponseDto.<List<ListDependencyDto>>builder().
				data(dependencyService.listDependency()).
				message("sucess").build();
	}

}
