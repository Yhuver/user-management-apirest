package com.user.management.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.management.dto.ApiResponseDto;
import com.user.management.dto.CreateTaskUserDto;
import com.user.management.dto.ListTaskUserDto;
import com.user.management.service.ITaskUserService;
import com.user.management.util.EndponitUtil;

@CrossOrigin("*")
@RestController
@RequestMapping(EndponitUtil.PATH_TASK_USER)
public class TaskUserController {

	private final static String success="success";
	
	@Autowired
	private ITaskUserService taskUserService;
	
	@PostMapping()
	public ApiResponseDto<String> createTaskUser(@Valid @RequestBody CreateTaskUserDto createTaskUserDto){
		
		return ApiResponseDto.<String>builder().
				data(taskUserService.createTaskUser(createTaskUserDto)).
				message(success).build();
	}
	
	@DeleteMapping
	public ApiResponseDto<String> deleteTaskUser(@RequestHeader(required = true) Long idTaskUser){
		
		return ApiResponseDto.<String>builder().
				data(taskUserService.deleteTaskUser(idTaskUser)).
				message(success).build();
	}
	
	@GetMapping()
	public ApiResponseDto<List<ListTaskUserDto>> listTaskByIdUser(@RequestHeader(required = true) Long idUser){
		
		return ApiResponseDto.<List<ListTaskUserDto>>builder().
				data(taskUserService.listTaskByIdUser(idUser)).
				message("sucess").build();
	}
}
