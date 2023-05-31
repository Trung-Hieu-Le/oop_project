package com.home_project.oop_project.entity;

import org.springframework.beans.factory.annotation.Value;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "fullname")
	private String fullName;
	
    @Column(name = "username")
	private String userName;

	@Column(name = "password")
	private String password;

    @Column(name = "dia_chi")
	private String diaChi;

    @Column(name = "email")
	private String email;

    @Column(name = "sdt")
    @Value("0")
	private long sdt;

    public User(){}
    
    public User(String fullName, String userName, String password, String diaChi, String email, long sdt) {
        this.fullName = fullName;
        this.userName = userName;
        this.password = password;
        this.diaChi = diaChi;
        this.email = email;
        this.sdt = sdt;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    
}
