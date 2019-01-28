package com.invillia.acme.models;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ORDER_TABLE")
public class MyOrder implements Serializable{

	private static final long serialVersionUID = 2L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence_order")
	@SequenceGenerator(name = "id_Sequence_order", sequenceName = "ID_SEQ_ORDER")	
    private Long id;

	@Column
	@Size(max=30)
	private String address;

	@Column
	private ZonedDateTime confirmationDate;

	@Column
	@Size(max=10)
	private String status;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "MYORDER_MYORDERSITEMS", joinColumns = {
            @JoinColumn(name = "MYORDER_ID") }, inverseJoinColumns = {
            @JoinColumn(name = "MYORDERITEM_ID") })
	Set<MyOrderItem> MyOrderItems;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
	
	public Set<MyOrderItem> getMyOrderItems() {
		return MyOrderItems;
	}

	public void setMyOrderItems(Set<MyOrderItem> myOrderItems) {
		MyOrderItems = myOrderItems;
	}

}
