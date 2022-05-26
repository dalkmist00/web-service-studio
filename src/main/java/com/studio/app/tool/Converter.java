package com.studio.app.tool;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.studio.app.dynamo.model.PersistentObject;
import com.studio.app.dynamo.model.UserDTO;

@Component
public class Converter {
	@Autowired
	Utils utils;
	
	public PersistentObject dtoToPo(UserDTO dto) {
		PersistentObject po = new PersistentObject();
		
		po.setUsername(dto.getUsername());
		po.setPassword(dto.getPassword());
		po.setCreationDate(dto.getCreationDate());
		po.setPk(utils.createPk());
		po.setSk(utils.createSk(dto));
		return po;
	}
	public UserDTO newUserToDto(Map<String,String> userParam) {
		UserDTO dto = new UserDTO();
		dto.setUsername(userParam.get("username"));
		dto.setPassword(userParam.get("password"));
		dto.setCreationDate(userParam.get("creation_date"));
		return dto;
	}

	public Map<String,String> newUserToMap(String user, String pass){
		Map<String,String> response = new HashMap<String, String>();
		response.put("username", user);
		response.put("password", pass);
		response.put("creation_date", utils.actualTime());
		return response;
	}
}
