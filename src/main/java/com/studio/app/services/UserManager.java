package com.studio.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.studio.app.dynamo.DynamoDao;
import com.studio.app.dynamo.model.PersistentObject;
import com.studio.app.dynamo.model.UserDTO;
import com.studio.app.tool.Converter;

@Component
public class UserManager {
	
	@Autowired
	Converter converter;
	
	@Autowired
	DynamoDao repo;
	
	public boolean createUser(UserDTO dto) {
		PersistentObject po = converter.dtoToPo(dto);
		if(null == repo.load(po)) {
			repo.save(po);
			return true;
		}else {
			return false;
		}
	}
}
