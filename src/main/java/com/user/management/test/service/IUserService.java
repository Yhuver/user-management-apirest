package com.user.management.test.service;


import java.util.List;

import com.user.management.test.dto.CreateUserDto;
import com.user.management.test.dto.ListUserDto;
import com.user.management.test.dto.UpdateUserDto;
import com.user.management.test.model.entity.User;

public interface IUserService {
	
	public String createUser(CreateUserDto createUserDto);
	
	public String updateUser(UpdateUserDto updateUserDto);
	
	public List<ListUserDto> listUser();
	
	public String deleteUser(Long idUser);
	
	public User getUser(Long idUser);
	
	
}
