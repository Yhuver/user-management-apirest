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
public class UpdateTaskDto {
	
	@NotNull(message = "{notnull}")
	private long idTask;

	private String name;
	
	private String description;
	
	private Boolean status;
	
	private Integer duration;
}
