package com.user.management.test.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListDependencyDto {
	
	private Long idDependency;
	
	private String nameDependency;

}
