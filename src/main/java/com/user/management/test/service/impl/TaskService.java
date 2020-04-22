package com.user.management.test.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.user.management.test.exception.CustomException;
import com.user.management.test.model.dao.ITaskDao;
import com.user.management.test.model.entity.Task;
import com.user.management.test.service.ITaskService;

@Service
public class TaskService implements ITaskService{
	
	@Autowired
	private ITaskDao taskDao;

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

}
