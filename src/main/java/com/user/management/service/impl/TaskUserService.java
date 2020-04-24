package com.user.management.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.user.management.dto.CreateTaskUserDto;
import com.user.management.dto.ListTaskUserDto;
import com.user.management.exception.CustomException;
import com.user.management.model.dao.ITaskUserCustomDao;
import com.user.management.model.dao.ITaskUserDao;
import com.user.management.model.entity.TaskUser;
import com.user.management.model.entity.User;
import com.user.management.service.ITaskService;
import com.user.management.service.ITaskUserService;
import com.user.management.service.IUserService;

@Service
public class TaskUserService implements ITaskUserService{
	
	private final static String success="success";

	@Autowired
	private ITaskUserDao taskUserDao;
	
	@Autowired
	private ITaskUserCustomDao taskUserCustomDao;
	
	@Autowired
	private ITaskService taskService;
	
	@Autowired
	private IUserService userService;
	
	@Override
	public String createTaskUser(CreateTaskUserDto createTaskUserDto) {
		
		TaskUser taskUser=new TaskUser();
		taskUser.setTask(taskService.getTask(createTaskUserDto.getIdTask()));
		taskUser.setUser(userService.getUser(createTaskUserDto.getIdUser()));
		if(taskUserDao.existsByUserAndTask(taskUser.getUser(), taskUser.getTask())) {
			throw new CustomException("Esta tarea y este usuario ya se encuentran relacionados", HttpStatus.NOT_FOUND);
		}
		
		taskUserDao.save(taskUser);
		
		return success;
	}

	@Override
	public String deleteTaskUser(Long idTaskUser) {
		taskUserDao.delete(getTaskUser(idTaskUser));
		return success;
	}

	@Override
	public List<ListTaskUserDto> listTaskByIdUser(Long idUser) {

		return taskUserCustomDao.listTaskByIdUser(userService.getUser(idUser));
	}
	
	@Override
	public TaskUser getTaskUser(Long idTaskUser) {
		Optional<TaskUser> opt=taskUserDao.findById(idTaskUser);
		if(opt.isPresent()) {
			return opt.get();
		}
		else {
			throw new CustomException("No se encontro esta Tarea relacionada a el usuario", HttpStatus.NOT_FOUND);
		}
	}

}
