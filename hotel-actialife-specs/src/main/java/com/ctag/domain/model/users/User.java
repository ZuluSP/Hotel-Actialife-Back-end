package com.ctag.domain.model.users;

import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.seedstack.business.domain.BaseAggregateRoot;

import com.ctag.domain.model.logs.LogCustom;
import com.ctag.domain.model.reservas.Reserva;
import com.ctag.domain.model.roles.RoleCustom;
import com.ctag.domain.model.roles.RolesCustomId;
import com.ctag.paperless.utils.constants.Constants;

@Entity
@Table(name = User.TABLE_NAME)
@IdClass(value = UserId.class)
public class User extends BaseAggregateRoot<UserId> {

	private static final String MAPPED_BY = "user";
	private static final String FIELD_NAME = "nombre";
	private static final String PK_ID = "id";
	private static final String GENERATOR = "UserGen";
	private static final String FK_ROL_USUARIO = "rol_usuario";
	private static final String FIELD_SURNAME = "apellidos";
	private static final String FIELD_EMAIL = "email";
	private static final String FIELD_TEL = "telf";
	private static final String FIELD_ADDRESS = "direccion";
	private static final String FIELD_PASS = "password";
	private static final String ATT_LOG = "log";
	protected static final String TABLE_NAME = "usuarios";

	@TableGenerator(name = GENERATOR, table = Constants.SEQUENCE, pkColumnName = Constants.KEY_VAL, valueColumnName = Constants.VALUE, pkColumnValue = TABLE_NAME, allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = GENERATOR)
	@Column(name = PK_ID, nullable = false, unique = true)
	private Integer id;

	@Column(name = FIELD_NAME)
	private String name;

	@Column(name = FIELD_SURNAME)
	private String surname;

	@Column(name = FIELD_EMAIL)
	private String email;

	@Column(name = FIELD_TEL)
	private String telf;

	@Column(name = FIELD_ADDRESS)
	private String address;

	@Column(name = FIELD_PASS)
	private String password;

	@OneToMany(mappedBy = ATT_LOG, cascade = CascadeType.ALL)
	private Set<LogCustom> logs;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = FK_ROL_USUARIO, nullable = false, insertable = false, updatable = false)
	private RoleCustom roles;

	@Embedded
	@AttributeOverride(name = Constants.ID, column = @Column(name = FK_ROL_USUARIO, nullable = true))
	private RolesCustomId roleId;

	@OneToMany(mappedBy = MAPPED_BY)
	private List<Reserva> reservas;

	User() {
		// Required by Hibernate
	}

	protected User(UserId id) {
		// Required by Hibernate
	}

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
		User castOther = (User) other;
		return new EqualsBuilder().append(id, castOther.id).isEquals();
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public UserId getId() {

		return new UserId(id);
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public RolesCustomId getRoleId() {
		return roleId;
	}

	public RoleCustom getRoles() {
		return roles;
	}

	public String getSurname() {
		return surname;
	}

	public String getTelf() {
		return telf;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).toHashCode();
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRoleId(RolesCustomId roleId) {
		this.roleId = roleId;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setTelf(String telf) {
		this.telf = telf;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email + ", telf=" + telf
				+ ", direccion=" + address + ", password=" + password + ", roles=" + roles + ", role_id=" + roleId
				+ "]";
	}
}
