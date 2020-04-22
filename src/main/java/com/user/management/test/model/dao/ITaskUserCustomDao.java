package com.user.management.test.model.dao;

import java.util.List;

import com.user.management.test.dto.ListProfileUserDto;
import com.user.management.test.dto.ListTaskUserDto;
import com.user.management.test.model.entity.User;

public interface ITaskUserCustomDao {

	public List<ListTaskUserDto> listTaskByIdUser(User user);
}
