package com.user.management.dto;

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
public class ListProfileUserDto {
	
	private static final Logger LOGGER = LogManager.getLogger(ListProfileUserDto.class);
	
	private Long idProfileUser;
	
	private Long idProfile;
	
	private String nameProfile;
	
	private String descriptionProfile;
	
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
