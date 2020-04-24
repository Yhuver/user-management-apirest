package com.user.management.model.dao;

import java.util.List;

import com.user.management.dto.ListProfileUserDto;
import com.user.management.dto.ListTaskUserDto;
import com.user.management.model.entity.User;

public interface ITaskUserCustomDao {

	public List<ListTaskUserDto> listTaskByIdUser(User user);
}
