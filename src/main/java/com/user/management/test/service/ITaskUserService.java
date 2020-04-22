package com.user.management.test.service;

import java.util.List;

import com.user.management.test.dto.CreateTaskUserDto;
import com.user.management.test.dto.ListTaskUserDto;
import com.user.management.test.model.entity.TaskUser;

public interface ITaskUserService {

	public String createTaskUser(CreateTaskUserDto createTaskUserDto);
	
	public String deleteTaskUser(Long idTaskUser);
	
	public List<ListTaskUserDto> listTaskByIdUser(Long idUser);

	TaskUser getTaskUser(Long idTaskUser);
	
}
