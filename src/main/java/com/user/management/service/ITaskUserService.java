package com.user.management.service;

import java.util.List;

import com.user.management.dto.CreateTaskUserDto;
import com.user.management.dto.ListTaskUserDto;
import com.user.management.model.entity.TaskUser;

public interface ITaskUserService {

	public String createTaskUser(CreateTaskUserDto createTaskUserDto);
	
	public String deleteTaskUser(Long idTaskUser);
	
	public List<ListTaskUserDto> listTaskByIdUser(Long idUser);

	TaskUser getTaskUser(Long idTaskUser);
	
}
