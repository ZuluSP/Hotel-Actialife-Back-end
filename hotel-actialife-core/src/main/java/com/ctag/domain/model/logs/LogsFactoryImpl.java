package com.ctag.domain.model.logs;

import javax.inject.Inject;

import org.seedstack.business.domain.BaseFactory;

import com.ctag.domain.model.users.UserId;

public class LogsFactoryImpl extends BaseFactory<LogCustom> implements LogsFactory {

  private final LogsRepository repo;

  @Inject
  public LogsFactoryImpl(LogsRepository repo) {
    this.repo = repo;
  }

  @Override
  public LogCustom createLog(Integer userId, String logText, String time) {

    LogCustom log = this.create();
    log.setUserId(new UserId(userId));
    log.setLog(logText);
    log.setTime(time);

    repo.add(log);

    return log;
  }
}
