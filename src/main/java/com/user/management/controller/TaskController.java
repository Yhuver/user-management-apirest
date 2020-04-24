package com.user.management.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.management.dto.ApiResponseDto;
import com.user.management.dto.CreateTaskDto;
import com.user.management.dto.ListTaskDto;
import com.user.management.dto.UpdateTaskDto;
import com.user.management.service.ITaskService;
import com.user.management.util.EndponitUtil;

@CrossOrigin("*")
@RestController
@RequestMapping(EndponitUtil.PATH_TASK)
public class TaskController {
	
	private final static String success="success";
	
	@Autowired
	private ITaskService taskService;
	

	@GetMapping()
	public ApiResponseDto<List<ListTaskDto>> listTask(){
		
		return ApiResponseDto.<List<ListTaskDto>>builder().
				data(taskService.listTask()).
				message("sucess").build();
	}
	
	@PostMapping()
	public ApiResponseDto<String> createTask(@Valid @RequestBody CreateTaskDto createTaskDto){
		
		return ApiResponseDto.<String>builder().
				data(taskService.createTask(createTaskDto)).
				message(success).build();
	}
	
	@PutMapping()
	public ApiResponseDto<String> updateUser(@Valid @RequestBody UpdateTaskDto updateTaskDto){
		
		return ApiResponseDto.<String>builder().
				data(taskService.updateTask(updateTaskDto)).
				message(success).build();
	}
	
	@DeleteMapping
	public ApiResponseDto<String> deleteUser(@RequestHeader(required = true) Long idTask){
		
		return ApiResponseDto.<String>builder().
				data(taskService.deleteTask(idTask)).
				message(success).build();
	}
	
}
