package com.user.management.test.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.management.test.dto.ApiResponseDto;
import com.user.management.test.dto.ListTaskDto;
import com.user.management.test.util.EndponitUtil;

@CrossOrigin("*")
@RestController
@RequestMapping(EndponitUtil.PATH_TASK)
public class TaskController {

	@GetMapping()
	public ApiResponseDto<List<ListTaskDto>> listUser(){
		
		return ApiResponseDto.<List<ListTaskDto>>builder().
				data(null).
				message("sucess").build();
	}
	
}