// package com.invillia.acme.models;

// import java.time.ZonedDateTime;

// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.Table;

// import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// @Entity
// @Table(name="payment")
// @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
// public class Payment {
	
// 	@Id
//     @GeneratedValue(strategy=GenerationType.AUTO)
//     private Integer id;
	
// 	@Column(name="status")
// 	private String status;
	
// 	@Column(name="creditCard")
// 	private String creditCard;
	
// 	@Column(name="paymentDate")
// 	private ZonedDateTime paymentDate;
	
// 	public Integer getId() {
// 		return id;
// 	}

// 	public void setId(Integer id) {
// 		this.id = id;
// 	}

// 	public String getStatus() {
// 		return status;
// 	}

// 	public void setStatus(String status) {
// 		this.status = status;
// 	}

// 	public String getCreditCard() {
// 		return creditCard;
// 	}

// 	public void setCreditCard(String creditCard) {
// 		this.creditCard = creditCard;
// 	}

// 	public ZonedDateTime getPaymentDate() {
// 		return paymentDate;
// 	}

// 	public void setPaymentDate(ZonedDateTime paymentDate) {
// 		this.paymentDate = paymentDate;
// 	}
// }
