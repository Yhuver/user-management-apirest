package com.user.management.test.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.user.management.test.dto.CreateProfileUserDto;
import com.user.management.test.dto.ListProfileUserDto;
import com.user.management.test.exception.CustomException;
import com.user.management.test.model.dao.IProfileUserCustomDao;
import com.user.management.test.model.dao.IProfileUserDao;
import com.user.management.test.model.entity.ProfileUser;
import com.user.management.test.service.IProfileService;
import com.user.management.test.service.IProfileUserService;
import com.user.management.test.service.IUserService;

@Service
public class ProfileUserService implements IProfileUserService{

	private final static String success="success";
	
	@Autowired
	private IProfileUserDao profileUserDao;
	
	@Autowired
	private IProfileUserCustomDao profileUserCustomDao;
	
	@Autowired
	private IProfileService profileService;
	
	@Autowired
	private IUserService userService;
	
	@Override
	public String createProfileUser(CreateProfileUserDto createProfileUserDto) {
		ProfileUser profileUser=new ProfileUser();
		profileUser.setUser(userService.getUser(createProfileUserDto.getIdUser()));
		profileUser.setProfile(profileService.getProfile(createProfileUserDto.getIdProfile()));
		profileUserDao.save(profileUser);
		
		return success;
	}

	@Override
	public String deleteProfileUser(Long idProfileUser) {
		profileUserDao.delete(getProfileUser(idProfileUser));
		return success;
	}

	@Override
	public List<ListProfileUserDto> listProfileByIdUser(Long idUser) {
		
		return profileUserCustomDao.listProfileByIdUser(userService.getUser(idUser));
	}

	@Override
	public ProfileUser getProfileUser(Long idProfileUser) {
		Optional<ProfileUser> opt=profileUserDao.findById(idProfileUser);
		if(opt.isPresent()) {
			return opt.get();
		}
		else {
			throw new CustomException("No se encontro este Perfil relacionado a el usuario", HttpStatus.NOT_FOUND);
		}
	}

}
