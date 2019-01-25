package com.invillia.acme.models;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="order")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Order {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
	
	@Column(name="address")
	private String address;
	
	@Column(name="confirmationDate")
	private ZonedDateTime confirmationDate;
	
	@Column(name="status")
	private String status;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ZonedDateTime getConfirmationDate() {
		return confirmationDate;
	}

	public void setConfirmationDate(ZonedDateTime confirmationDate) {
		this.confirmationDate = confirmationDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
