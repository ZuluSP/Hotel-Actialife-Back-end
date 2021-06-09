package com.ctag.domain.model.logs;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.seedstack.business.domain.BaseAggregateRoot;

import com.ctag.domain.model.users.User;
import com.ctag.domain.model.users.UserId;
import com.ctag.paperless.utils.constants.Constants;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@IdClass(value = LogsCustomId.class)
@Table(name = LogCustom.TABLE_NAME)
public class LogCustom extends BaseAggregateRoot<LogsCustomId> {

  public static final String TABLE_NAME = "logs";
  private static final String GENERATOR = "LogsGen";

  private static final String PK_ID = "id";
  private static final String FIELD_LOG = "log";
  private static final String FIELD_TIME = "time";
  private static final String AK_ID_USUARIO = "id_usuario";

  @TableGenerator(
      name = GENERATOR,
      table = Constants.SEQUENCE,
      pkColumnName = Constants.KEY_VAL,
      valueColumnName = Constants.VALUE,
      pkColumnValue = TABLE_NAME,
      allocationSize = 1)
  @Id
  @GeneratedValue(strategy = GenerationType.TABLE, generator = GENERATOR)
  @Column(name = PK_ID, unique = true, nullable = false)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = AK_ID_USUARIO, nullable = false, insertable = false, updatable = false)
  private User user;

  @Embedded
  @AttributeOverride(name = Constants.ID, column = @Column(name = AK_ID_USUARIO, nullable = true))
  private UserId userId;

  @Column(name = FIELD_LOG)
  private String log;

  @Column(name = FIELD_TIME)
  private String time;

  public LogCustom() {}

  @Override
  public boolean equals(final Object other) {
    if (this == other) {
      return true;
    }
    if (other == null) {
      return false;
    }
    if (!getClass().equals(other.getClass())) {
      return false;
    }
    LogCustom castOther = (LogCustom) other;
    return new EqualsBuilder().append(id, castOther.id).isEquals();
  }

  @Override
  public LogsCustomId getId() {
    return new LogsCustomId(id);
  }

  public String getLog() {
    return log;
  }

  public String getTime() {
    return time;
  }

  public User getUser() {
    return user;
  }

  public UserId getUserId() {
    return userId;
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder().append(id).toHashCode();
  }

  public void setLog(String log) {
    this.log = log;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public void setUserId(UserId userId) {
    this.userId = userId;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("user", user)
        .append("userId", userId)
        .append("log", log)
        .append("time", time)
        .toString();
  }
}
