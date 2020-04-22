package com.user.management.test.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserDto {

	@NotNull(message = "{notnull}")
	private Long idUser;
	
	private String name;
	
	private Boolean status;
	
	private Long idDependency;
	
	private LocalDate birthDate;
}
