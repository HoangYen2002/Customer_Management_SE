package com.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity(name = "Customers")
@Table(name = "Customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "Name")
	@NotEmpty(message = "Name is required")
	@Length(min = 3, max = 50, message = "Maximum character is 50")
	private String name;
	
	@Column(name = "Age")
	//@NotEmpty(message = "Age is required")
	//@Digits(integer = 100, fraction = 0)
	@Min(10)
	
	private int age;
	
	@Column(name = "Phone_Number")
	@NotEmpty(message = "Phone number is required")
	@Length(max = 10, message = "Phone Number is required.")
	private String phone_Number;
	
	@Temporal(TemporalType.DATE)
	private Date updatedAt;
	 
	
	public Customer() {
		super();
	}

	public Customer(int id, String name, int age, String phone_Number, Date updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.phone_Number = phone_Number;
		this.updatedAt = updatedAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone_Number() {
		return phone_Number;
	}

	public void setPhone_Number(String phone_Number) {
		this.phone_Number = phone_Number;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	

}
