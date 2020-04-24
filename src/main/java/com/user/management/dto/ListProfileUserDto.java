package com.user.management.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListProfileUserDto {
	
	private Long idProfileUser;
	
	private Long idProfile;
	
	private String nameProfile;
	
	private String descriptionProfile;

}
