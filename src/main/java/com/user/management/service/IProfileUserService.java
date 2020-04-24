package com.user.management.service;

import java.util.List;

import com.user.management.dto.CreateProfileUserDto;
import com.user.management.dto.ListProfileUserDto;
import com.user.management.model.entity.ProfileUser;

public interface IProfileUserService {
	
	public String createProfileUser(CreateProfileUserDto createProfileUserDto);
	
	public String deleteProfileUser(Long idProfileUser);
	
	public List<ListProfileUserDto> listProfileByIdUser(Long idUser);
	
	public ProfileUser getProfileUser(Long idProfileUser);

}
