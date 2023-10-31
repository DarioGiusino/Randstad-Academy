package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Doctor {

	@Id
	@GeneratedValue
	private Long id;

	private String name;
	
//	@OneToMany(mappedBy = "doctor")
//	private List<Appointment> appointmentList;

	public Doctor() {
	};

	public Doctor(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
//		this.appointmentList = new ArrayList<>();
	}

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

//	public List<Appointment> getAppointmentList() {
//		return appointmentList;
//	}
//
//	public void setAppointmentList(List<Appointment> appointmentList) {
//		this.appointmentList = appointmentList;
//	}

}
