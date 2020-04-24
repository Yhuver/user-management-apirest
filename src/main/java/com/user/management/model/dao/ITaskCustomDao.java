package com.user.management.model.dao;

import java.util.List;

import com.user.management.dto.ListTaskDto;
import com.user.management.model.entity.User;

public interface ITaskCustomDao {
	
	public List<ListTaskDto> listTaskExceptByUser(User user);

}
