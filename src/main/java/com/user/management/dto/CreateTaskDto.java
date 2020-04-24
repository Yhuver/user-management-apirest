package com.user.management.dto;


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
public class CreateTaskDto {
	
	@NotNull(message = "{notnull}")
	@NotEmpty(message = "{notempty}")
	private String name;
	
	@NotNull(message = "{notnull}")
	@NotEmpty(message = "{notempty}")
	private String description;
	
	@NotNull(message = "{notnull}")
	private Boolean status;
	
	@NotNull(message = "{notnull}")
	private Integer duration;

}
