package com.user.management.dto;

import java.time.LocalDate;

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
public class ListUserDto {
	
	private static final Logger LOGGER = LogManager.getLogger(ListUserDto.class);

	
	private Long idUser;
	
	private String nameUser;
	
	private Long idDependency;
	
	private String nameDependency;
	
	private LocalDate birthDate;
	
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
