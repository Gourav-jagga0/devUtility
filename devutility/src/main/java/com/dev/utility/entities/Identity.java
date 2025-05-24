package com.dev.utility.entities;

import java.util.Date;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "identity")
@NamedQueries(@NamedQuery(name = "getfullName", query = "select CONCAT(firstName,lastname) from Identity i where id = ?1 "))
public class Identity extends baseEntity{
	
	private String firstName;
	private String lastname;
	private String mail;
	private String type;
	private Date DOB;
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	@Override
	public String toString() {
		return "Identity [ firstName=" + firstName + ", lastname=" + lastname + ", mail=" + mail
				+ ", type=" + type + ", DOB=" + DOB + "]";
	}

}
