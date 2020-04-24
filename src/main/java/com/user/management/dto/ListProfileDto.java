package com.user.management.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListProfileDto {
	
	private Long idProfile;
	
	private String nameProfile;

}
