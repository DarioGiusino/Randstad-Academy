package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

public class Appointment {
	@Id
	@GeneratedValue
	private Long id;

	private LocalDateTime dateAndTime;
	private String customerName;
	private String description;
	
//	@ManyToOne
//	private Doctor doctor;

	public Appointment() {
	};

	public Appointment(Long id, LocalDateTime dateAndTime, String customerName, String description) {
		super();
		this.id = id;
		this.dateAndTime = dateAndTime;
		this.customerName = customerName;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(LocalDateTime dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public Doctor getDoctor() {
//		return this.doctor;
//	}
//
//	public void setDoctor(Doctor doctor) {
//		this.doctor = doctor;
//	}
	

}
