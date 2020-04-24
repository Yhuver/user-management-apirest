package com.user.management.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDto {
	
	@NotNull(message = "{notnull}")
	@NotEmpty(message = "{notempty}")
	private String name;
	
	@NotNull(message = "{notnull}")
	private LocalDate birthDate;
	
	@NotNull(message = "{notnull}")
	private Long idDependency;
	
	@NotNull(message = "{notnull}")
	private Boolean status;
	

}
