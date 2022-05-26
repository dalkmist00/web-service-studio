package com.studio.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.studio.app.dynamo.DynamoDao;
import com.studio.app.dynamo.model.PersistentObject;
import com.studio.app.dynamo.model.UserDTO;
import com.studio.app.tool.Converter;

@Component
public class LogManager {
	
	@Autowired
	Converter converter;
	
	@Autowired
	DynamoDao repo;
	
	public boolean log(UserDTO dto) {
		PersistentObject po = repo.load(converter.dtoToPo(dto));
		return(isPresent(po) && checkPass(po,dto));
	}
	
	private boolean checkPass(PersistentObject po,UserDTO dto) {
		return po.getPassword().equals(dto.getPassword());
	}
	
	private boolean isPresent(PersistentObject po) {
		return null != po;
	}
}
