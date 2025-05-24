package com.dev.utility.entities;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class baseEntity {
	@Id
	@Column(name = "id", unique = true, updatable = false)
	@GenericGenerator(name = "sequence_generator", strategy = "com.dev.utility.idgenerator.IdeGenerator")
	@GeneratedValue(generator = "sequence_generator")
	private Long id;
	@CreationTimestamp
	@Column(name = "created_on", updatable = false, nullable = false)
	private Date createdOn;
	@UpdateTimestamp
	@Column(name = "changed_on", nullable = false)
	private Date changedOn;
	@Column(name = "record_status", nullable = false)
	@Enumerated(EnumType.STRING)
	private RowStatus rec_status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RowStatus getRec_status() {
		return rec_status;
	}

	public void setRec_status(RowStatus rec_status) {
		this.rec_status = rec_status;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getChangedOn() {
		return changedOn;
	}

	public void setChangedOn(Date changedOn) {
		this.changedOn = new Date();
	}

}
