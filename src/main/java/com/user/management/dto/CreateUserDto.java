package com.user.management.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDto {
	
	private static final Logger LOGGER = LogManager.getLogger(CreateUserDto.class);
	
	@NotNull(message = "{notnull}")
	@NotEmpty(message = "{notempty}")
	private String name;
	
	@NotNull(message = "{notnull}")
	private LocalDate birthDate;
	
	@NotNull(message = "{notnull}")
	private Long idDependency;
	
	@NotNull(message = "{notnull}")
	private Boolean status;
	
	public String toStringJson() {

		String jsonString = "";

		try {

			ObjectMapper mapper = new ObjectMapper();
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
			jsonString = mapper.writeValueAsString(this);

		} catch (JsonProcessingException e) {
			LOGGER.error(e);
		}

		return jsonString;
	}

}
