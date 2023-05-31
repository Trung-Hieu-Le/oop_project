package com.home_project.oop_project.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;

@Entity
@Table(name = "shippers")
public class Shipper {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "fullname")
	private String fullName;
	
	// @Column(name = "password")
	// private String password;

    @Column(name = "ngay_sinh")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngaySinh;

    @Column(name = "dia_chi")
	private String diaChi;

    @Column(name = "email")
	private String email;

    @Column(name = "sdt")
	private long sdt;

    @Column(name = "cccd")
	private long cccd;

    public Shipper(){}

    public Shipper(String fullName, Date ngaySinh, String diaChi, String email, long sdt, long cccd) {
        this.fullName = fullName;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.email = email;
        this.sdt = sdt;
        this.cccd = cccd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getSdt() {
        return sdt;
    }

    public void setSdt(long sdt) {
        this.sdt = sdt;
    }

    public long getCccd() {
        return cccd;
    }

    public void setCccd(long cccd) {
        this.cccd = cccd;
    }


}
