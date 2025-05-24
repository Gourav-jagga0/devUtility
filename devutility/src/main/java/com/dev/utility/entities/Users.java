package com.dev.utility.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Users extends baseEntity {

	private String password;
	
	@OneToOne(targetEntity = Identity.class,optional = false)
	@JoinColumn(name = "identityId", referencedColumnName = "id", insertable = false, updatable = false)
	Identity identity;
	@Column(name="identityId",unique =true,nullable = false)
	Long identityId;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Identity getIdentity() {
		return identity;
	}

	public void setIdentity(Identity identity) {
		this.identity = identity;
	}

	public Long getIdentityId() {
		return identityId;
	}

	public void setIdentityId(Long identityId) {
		this.identityId = identityId;
	}

}
