package com.invillia.acme.models;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="store")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Store {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="status")
	private String status;
	
	@Column(name="andress")
	private String andress;
	
	@Column(name="datatime")
	private ZonedDateTime datatime;

	@ManyToMany
	@ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "orders")
	@JoinColumn(name = "id", nullable = false)
	@Column(name="orders")
	private Set<Order> orders = new HashSet<>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAndress() {
		return andress;
	}
	public void setAndress(String andress) {
		this.andress = andress;
	}
	public ZonedDateTime getDatatime() {
		return datatime;
	}
	public void setDatatime(ZonedDateTime datatime) {
		this.datatime = datatime;
	}

	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
}
