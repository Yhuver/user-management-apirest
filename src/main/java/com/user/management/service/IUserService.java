package com.user.management.service;


import java.util.List;

import com.user.management.dto.CreateUserDto;
import com.user.management.dto.ListUserDto;
import com.user.management.dto.UpdateUserDto;
import com.user.management.model.entity.User;

public interface IUserService {
	
	public String createUser(CreateUserDto createUserDto);
	
	public String updateUser(UpdateUserDto updateUserDto);
	
	public List<ListUserDto> listUser();
	
	public String deleteUser(Long idUser);
	
	public User getUser(Long idUser);
	
	
}
