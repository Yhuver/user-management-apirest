package com.user.management.test.service;

import java.util.List;

import com.user.management.test.dto.ListProfileDto;
import com.user.management.test.model.entity.Profile;

public interface IProfileService {
	
	
	public List<ListProfileDto> listProfile();

	public Profile getProfile(Long idProfile);
	
	
	
}
