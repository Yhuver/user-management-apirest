package com.user.management.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.user.management.dto.CreateTaskDto;
import com.user.management.dto.ListTaskDto;
import com.user.management.dto.UpdateTaskDto;
import com.user.management.exception.CustomException;
import com.user.management.model.dao.ITaskDao;
import com.user.management.model.dao.impl.TaskCustomDao;
import com.user.management.model.entity.Task;
import com.user.management.model.entity.User;
import com.user.management.service.ITaskService;
import com.user.management.service.IUserService;

@Service
public class TaskService implements ITaskService{
	
	@Autowired
	private ITaskDao taskDao;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private TaskCustomDao taskCustomDao;

	@Override
	public Task getTask(Long idTask) {
		Optional<Task> opt=taskDao.findById(idTask);
		if(opt.isPresent()) {
			return opt.get();
		}
		else {
			throw new CustomException("No se encontro esta tarea", HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public List<ListTaskDto> listTask() {
		List<Task> list=taskDao.findAll();
		List<ListTaskDto> listResult=new ArrayList<>();
		for (Task task : list) {
			listResult.add(ListTaskDto.builder().
					idTask(task.getId()).
					nameTask(task.getName()).
					durationTask(task.getDuration()).
					statusTask(task.getStatus()).
					descriptionTask(task.getDescription())
					.build());
		}
		
		return listResult;
	}

	@Override
	public String createTask(CreateTaskDto createTaskDto) {
		
		if(taskDao.existsByName(createTaskDto.getName())) {
			throw new CustomException("Este nombre de Tarea ya existe", HttpStatus.CONFLICT); 
		}
		
		Task task=new Task();
		task.setName(createTaskDto.getName());
		task.setDescription(createTaskDto.getDescription());
		task.setDuration(createTaskDto.getDuration());
		task.setStatus(createTaskDto.getStatus());
		taskDao.save(task);
		
		return "success";
	}

	@Override
	public String updateTask(UpdateTaskDto updateTaskDto) {
		Task task=getTask(updateTaskDto.getIdTask());
		
		
		if(updateTaskDto.getName()!=null&&!updateTaskDto.getName().isEmpty()) {
			task.setName(updateTaskDto.getName());
		}
		if(updateTaskDto.getDescription()!=null&&!updateTaskDto.getDescription().isEmpty()) {
			task.setDescription(updateTaskDto.getDescription());
		}
		if(updateTaskDto.getDuration()!=null&&updateTaskDto.getDuration()>0) {
			task.setDuration(updateTaskDto.getDuration());
		}
		if(updateTaskDto.getStatus()!=null) {
			task.setStatus(updateTaskDto.getStatus());
		}
		taskDao.save(task);
		
		
		return "success";
	}

	@Transactional(rollbackFor = CustomException.class)
	@Override
	public String deleteTask(Long idTask) {
		try {
			taskDao.deleteById(idTask);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException("Error al intentar eliminar la Tarea", e);
		}
		return "success";
	}

	@Override
	public List<ListTaskDto> listTaskExceptByUser(Long idUser) {
		User user=userService.getUser(idUser);
		return taskCustomDao.listTaskExceptByUser(user);
	}

}
