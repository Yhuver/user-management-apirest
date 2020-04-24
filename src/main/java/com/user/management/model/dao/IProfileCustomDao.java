package com.user.management.model.dao;

import java.util.List;

import com.user.management.dto.ListProfileDto;
import com.user.management.model.entity.User;

public interface IProfileCustomDao {

	public List<ListProfileDto> listProfileExceptByUser(User user);
}
