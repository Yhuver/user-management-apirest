package com.user.management.test.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTaskUserDto {

	@NotNull(message = "{notnull}")
	private Long idUser;
	
	@NotNull(message = "{notnull}")
	private Long idTask;
}
