package com.user.management.service;

import java.util.List;

import com.user.management.dto.CreateTaskDto;
import com.user.management.dto.ListTaskDto;
import com.user.management.dto.UpdateTaskDto;
import com.user.management.model.entity.Task;


public interface ITaskService {
	
	public List<ListTaskDto> listTask();
	
	public String createTask(CreateTaskDto createTaskDto);
	
	public String updateTask(UpdateTaskDto updateTaskDto);
	
	public String deleteTask(Long idTask);
	
	public Task getTask(Long idTask);
	
	public List<ListTaskDto> listTaskExceptByUser(Long idUser);

}
