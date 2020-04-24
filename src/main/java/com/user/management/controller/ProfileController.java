package com.user.management.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.management.dto.ApiResponseDto;
import com.user.management.dto.ListProfileDto;
import com.user.management.service.IProfileService;
import com.user.management.util.EndponitUtil;

@CrossOrigin("*")
@RestController
@RequestMapping(EndponitUtil.PATH_PROFILE)
public class ProfileController {

	private static final Logger LOGGER = LogManager.getLogger(ProfileController.class);
	
	@Autowired
	private IProfileService profileService;
	
	@GetMapping()
	public ApiResponseDto<List<ListProfileDto>> listProfile(){
		
		LOGGER.info("Request Profile :\n" + "listProfile" );
		
		return ApiResponseDto.<List<ListProfileDto>>builder().
				data(profileService.listProfile()).
				message("sucess").build();
	}
	
	@GetMapping("/exceptByUser")
	public ApiResponseDto<List<ListProfileDto>> listProfileExceptByUser(@RequestHeader(required = true) Long idUser){
		
		LOGGER.info("Request Profile :\n" + "listProfileExceptByUser{ idUser:"+idUser+" }" );
		
		return ApiResponseDto.<List<ListProfileDto>>builder().
				data(profileService.listProfileExceptByUser(idUser)).
				message("sucess").build();
	}
}
