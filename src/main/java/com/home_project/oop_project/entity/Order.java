package com.home_project.oop_project.entity;
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
	
	@Column(name = "value")
	private long value;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "shipper_id")
	private long shipperID;

	@Column(name = "status")
	private String status;
	
	public Order(){}

	public Order(String startPoint, String endPoint, long value, String customerName, long shipperID, String status) {
		super();
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.value = value;
		this.customerName = customerName;
		this.shipperID = shipperID;
		this.status = status;
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

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getShipperID() {
		return shipperID;
	}

	public void setShipperID(long shipperID) {
		this.shipperID = shipperID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
