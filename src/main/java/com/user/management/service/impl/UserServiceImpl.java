package com.user.management.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.user.management.dto.CreateUserDto;
import com.user.management.dto.ListUserDto;
import com.user.management.dto.UpdateUserDto;
import com.user.management.exception.CustomException;
import com.user.management.model.dao.IUserDao;
import com.user.management.model.entity.User;
import com.user.management.service.IDependencyService;
import com.user.management.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private IDependencyService dependencyService;


	@Override
	public String createUser(CreateUserDto createUserDto) {
		
		if(userDao.existsByName(createUserDto.getName())) {
			throw new CustomException("Este nombre de usuario ya existe", HttpStatus.CONFLICT); 
		}
		
		User user=new User();
		user.setBirthDate(createUserDto.getBirthDate());
		user.setStatus(createUserDto.getStatus());
		user.setName(createUserDto.getName());
		user.setDependency(dependencyService.getDependency(createUserDto.getIdDependency()));
		userDao.save(user);
		
		return "success";
	}

	@Override
	public String updateUser(UpdateUserDto updateUserDto) {
		User user=getUser(updateUserDto.getIdUser());
		
		if(updateUserDto.getName()!=null&&!updateUserDto.getName().isEmpty()) {
			user.setName(updateUserDto.getName());
		}
		if(updateUserDto.getBirthDate()!=null) {
			user.setBirthDate(updateUserDto.getBirthDate());
		}
		if(updateUserDto.getIdDependency()!=null&&updateUserDto.getIdDependency()>0) {
			user.setDependency(dependencyService.getDependency(updateUserDto.getIdDependency()));
		}
		if(updateUserDto.getStatus()!=null) {
			user.setStatus(updateUserDto.getStatus());
		}
		
		userDao.save(user);
		
		return "success";
	}

	@Override
	public List<ListUserDto> listUser() {

		List<User> list=userDao.findAll();
		
		List<ListUserDto> listresult=new ArrayList<>();
		for (User user : list) {
			listresult.add(ListUserDto.builder().
					idUser(user.getId()).
					nameUser(user.getName()).
					idDependency(user.getDependency().getId()).
					nameDependency(user.getDependency().getName()).
					birthDate(user.getBirthDate()).
					status(user.getStatus()).build());
		}
		
		return listresult;
	}
	
	@Transactional(rollbackFor = CustomException.class)
	@Override
	public String deleteUser(Long idUser) {
		try {
		userDao.delete(getUser(idUser));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new CustomException("Error al intentar eliminar el Usuario", e);
		}
		return "success";
	}
	

	@Override
	public User getUser(Long idUser) {
		Optional<User> opt=userDao.findById(idUser);
		if(opt.isPresent()) {
			return opt.get();
		}
		else {
			throw new CustomException("No se encontro este usuario", HttpStatus.NOT_FOUND);
		}
	}

	
	
}
