package com.user.management.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.user.management.dto.ListProfileDto;
import com.user.management.exception.CustomException;
import com.user.management.model.dao.IProfileCustomDao;
import com.user.management.model.dao.IProfileDao;
import com.user.management.model.entity.Profile;
import com.user.management.service.IProfileService;
import com.user.management.service.IUserService;

@Service
public class ProfileService implements IProfileService{

	@Autowired
	private IProfileDao profileDao;
	
	@Autowired
	private IProfileCustomDao profileCustomDao;
	
	@Autowired
	private IUserService userService;
	
	@Override
	public Profile getProfile(Long idProfile) {
		Optional<Profile> opt=profileDao.findById(idProfile);
		if(opt.isPresent()) {
			return opt.get();
		}
		else {
			throw new CustomException("No se encontro este Perfil", HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public List<ListProfileDto> listProfile() {
		List<Profile> list=profileDao.findAll();
		List<ListProfileDto> listResult=new ArrayList<>();
		for (Profile profile : list) {
			listResult.add(ListProfileDto.builder().
					idProfile(profile.getId()).
					nameProfile(profile.getName()).build());
		}
		
		return listResult;
	}

	@Override
	public List<ListProfileDto> listProfileExceptByUser(Long idUser) {
		
		return profileCustomDao.listProfileExceptByUser(userService.getUser(idUser));
	}

}
