package com.user.management.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListTaskDto {
	
	private Long idTask;
	private String nameTask;
	private Integer durationTask;
	private Boolean statusTask;
	private String descriptionTask;

}