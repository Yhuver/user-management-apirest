package com.user.management.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.management.dto.ApiResponseDto;
import com.user.management.dto.CreateProfileUserDto;
import com.user.management.dto.ListProfileUserDto;
import com.user.management.service.IProfileUserService;
import com.user.management.util.EndponitUtil;

@CrossOrigin("*")
@RestController
@RequestMapping(EndponitUtil.PATH_PROFILE_USER)
public class ProfileUserController {
	
	private static final Logger LOGGER = LogManager.getLogger(ProfileUserController.class);
	
	private final static String success="success";
	
	@Autowired
	private IProfileUserService profileUserService;
	
	@PostMapping()
	public ApiResponseDto<String> createProfileUser(@Valid @RequestBody CreateProfileUserDto createProfileUserDto){
		
		LOGGER.info("Request ProfileUser :\n" + "createProfileUser" + createProfileUserDto.toStringJson() );
		
		return ApiResponseDto.<String>builder().
				data(profileUserService.createProfileUser(createProfileUserDto)).
				message(success).build();
	}

	@DeleteMapping
	public ApiResponseDto<String> deleteProfileUser(@RequestHeader(required = true) Long idProfileUser){
		
		LOGGER.info("Request ProfileUser :\n" + "deleteProfileUser data{ idProfileUser:"+idProfileUser+" }");
		
		return ApiResponseDto.<String>builder().
				data(profileUserService.deleteProfileUser(idProfileUser)).
				message(success).build();
	}
	
	@GetMapping()
	public ApiResponseDto<List<ListProfileUserDto>> listProfileByIdUser(@RequestHeader(required = true) Long idUser){
		
		LOGGER.info("Request ProfileUser :\n" + "listProfileByIdUser data{ idUser:"+idUser+" }");
		
		return ApiResponseDto.<List<ListProfileUserDto>>builder().
				data(profileUserService.listProfileByIdUser(idUser)).
				message("sucess").build();
	}
}
