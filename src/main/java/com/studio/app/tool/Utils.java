package com.studio.app.tool;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.springframework.stereotype.Component;

import com.studio.app.dynamo.model.UserDTO;

import static com.studio.app.tool.Constants.TENANT;
import static com.studio.app.tool.Constants.APPLICATION;
import static com.studio.app.tool.Constants.USER_SORT;

@Component
public class Utils {
	
	public String actualTime(){
        DateTimeFormatter dateFormatter = ISODateTimeFormat.dateTime();
        DateTime dateTime = DateTime.now(DateTimeZone.UTC);
        return dateTime.toString(dateFormatter);
    }
	
	public String createPk() {
		return String.join("#", TENANT,APPLICATION,USER_SORT);
	}
	
	public String createSk(UserDTO dto) {
		return dto.getUsername();
	}
}
