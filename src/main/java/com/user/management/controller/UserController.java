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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.management.dto.ApiResponseDto;
import com.user.management.dto.CreateUserDto;
import com.user.management.dto.ListUserDto;
import com.user.management.dto.UpdateUserDto;
import com.user.management.service.IUserService;
import com.user.management.util.EndponitUtil;

@CrossOrigin("*")
@RestController
@RequestMapping(EndponitUtil.PATH_USER)
public class UserController {
	
	private static final Logger LOGGER = LogManager.getLogger(UserController.class);

	
	private final static String success="success";
	
	@Autowired
	private IUserService userService;
	
	@PostMapping()
	public ApiResponseDto<String> createUser(@Valid @RequestBody CreateUserDto createUserDto){
		
		LOGGER.info("Request User :\n" + "createUser" + createUserDto.toStringJson() );
		
		return ApiResponseDto.<String>builder().
				data(userService.createUser(createUserDto)).
				message(success).build();
	}
	
	@PutMapping()
	public ApiResponseDto<String> updateUser(@Valid @RequestBody UpdateUserDto updateUserDto){
		
		LOGGER.info("Request User :\n" + "updateUser" + updateUserDto.toStringJson() );
		
		return ApiResponseDto.<String>builder().
				data(userService.updateUser(updateUserDto)).
				message(success).build();
	}
	
	@DeleteMapping
	public ApiResponseDto<String> deleteUser(@RequestHeader(required = true) Long idUser){
		
		LOGGER.info("Request User :\n" + "deleteUser data{ idUser:"+idUser+" }");
		
		return ApiResponseDto.<String>builder().
				data(userService.deleteUser(idUser)).
				message(success).build();
	}
	
	@GetMapping()
	public ApiResponseDto<List<ListUserDto>> listUser(){
		
		LOGGER.info("Request User :\n" + "listUser");
		
		return ApiResponseDto.<List<ListUserDto>>builder().
				data(userService.listUser()).
				message("sucess").build();
	}
}
