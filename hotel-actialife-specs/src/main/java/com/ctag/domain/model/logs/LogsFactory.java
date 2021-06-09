package com.ctag.domain.model.logs;

import org.seedstack.business.domain.Factory;
 
public interface LogsFactory extends Factory<LogCustom> {
 
	LogCustom createLog(Integer userId, String log, String time);
	
}
