package com.home_project.oop_project.entity;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "start_point", nullable = false)
	private String startPoint;
	
	@Column(name = "end_point", nullable = false)
	private String endPoint;
	
	@Column(name = "goodName")
	private String goodName;

	@Column(name = "goodType")
	private String goodType;

	@Column(name = "goodWeight")
	private String goodWeight;

	@Column(name = "customer_name")
	private String customerName;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "shipper_id")
	private Shipper shipper;

	@Column(name = "status")
	private String status;

	@Column(name = "created_at")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;

	@Column(name = "ghi_chu")
	private String ghiChu;
	
	public Order(){}

	public Order(String startPoint, String endPoint, String goodName, String goodType, String goodWeight, String customerName, User user, Shipper shipper, String status, Date createdAt, String ghiChu) {
		super();
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.goodName = goodName;
		this.goodType = goodType;
		this.goodWeight = goodWeight;
		this.customerName = customerName;
		this.user = user;
		this.shipper = shipper;
		this.status = status;
		this.createdAt = createdAt;
		this.ghiChu = ghiChu;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(String startPoint) {
		this.startPoint = startPoint;
	}

	public String getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

	public String getGoodWeight() {
		return goodWeight;
	}

	public void setGoodWeight(String goodWeight) {
		this.goodWeight = goodWeight;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Shipper getShipper() {
		return shipper;
	}

	public void setShipper(Shipper shipper) {
		this.shipper = shipper;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public String getGoodType() {
		return goodType;
	}

	public void setGoodType(String goodType) {
		this.goodType = goodType;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	

	
}
