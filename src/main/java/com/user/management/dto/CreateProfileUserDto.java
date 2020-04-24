package com.user.management.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProfileUserDto{

	@NotNull(message = "{notnull}")
	private Long idUser;
	
	@NotNull(message = "{notnull}")
	private Long idProfile;
	
}
