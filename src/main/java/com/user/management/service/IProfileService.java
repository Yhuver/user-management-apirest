package com.user.management.service;

import java.util.List;

import com.user.management.dto.ListProfileDto;
import com.user.management.model.entity.Profile;

public interface IProfileService {
	
	
	public List<ListProfileDto> listProfile();

	public Profile getProfile(Long idProfile);
	
	
	
}
