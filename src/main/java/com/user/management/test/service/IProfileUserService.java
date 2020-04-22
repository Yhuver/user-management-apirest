package com.user.management.test.service;

import java.util.List;

import com.user.management.test.dto.CreateProfileUserDto;
import com.user.management.test.dto.ListProfileUserDto;
import com.user.management.test.model.entity.ProfileUser;

public interface IProfileUserService {
	
	public String createProfileUser(CreateProfileUserDto createProfileUserDto);
	
	public String deleteProfileUser(Long idProfileUser);
	
	public List<ListProfileUserDto> listProfileByIdUser(Long idUser);
	
	public ProfileUser getProfileUser(Long idProfileUser);

}
