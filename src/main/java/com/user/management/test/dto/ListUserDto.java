package com.user.management.test.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListUserDto {
	
	private Long idUser;
	
	private String nameUser;
	
	private Long idDependency;
	
	private String nameDependency;
	
	private LocalDate birthDate;
	
	private Boolean status;
	

}
