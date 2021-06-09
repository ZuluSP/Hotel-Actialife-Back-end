package com.ctag.domain.model.logs;

import java.util.List;

import org.seedstack.business.domain.Repository;

import com.ctag.domain.model.users.UserId;

public interface LogsRepository extends Repository<LogCustom, LogsCustomId> {

	List <LogCustom> findLogsByUser(UserId id);
	
	List <LogCustom> getAllLogs();
	
}