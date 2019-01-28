package com.invillia.acme.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="STORE_TABLE")
public class MyStore implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator = "id_Sequence_store")
	@SequenceGenerator(name = "id_Sequence_store", sequenceName = "ID_SEQ_STORE")
    private Long id;
	
	@Column
	@Size(max=30)
	private String name;

	@Column
	@Size(max=30)
	private String address;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "MYSTORE_MYORDERS", joinColumns = {
            @JoinColumn(name = "MYSTORE_ID") }, inverseJoinColumns = {
            @JoinColumn(name = "MYORDER_ID") })
	Set<MyOrder> myOrders;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<MyOrder> getMyOrders() {
		return myOrders;
	}

	public void setMyOrders(Set<MyOrder> myOrders) {
		this.myOrders = myOrders;
	}

}
