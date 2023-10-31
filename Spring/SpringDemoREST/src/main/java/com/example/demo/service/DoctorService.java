package com.example.demo.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Doctor;

@Service
public class DoctorService {
	
	private final Map<Long, Doctor> doctorList = new HashMap<>();
	private Long currentId = 1L;

	public Doctor addDoctor(Doctor doctor) {
		doctor.setId(currentId++);
		doctorList.put(doctor.getId(), doctor);
		return doctor;
	}

	public Collection<Doctor> getAllDoctor() {
		return doctorList.values();
	}

	public Doctor getDoctorById(Long id) {
		return doctorList.get(id);
	}

	public Doctor updateDoctor(Long id, Doctor doctor) {
		if (doctorList.containsKey(id)) {
			doctor.setId(id);
			doctorList.put(id, doctor);
			return doctor;
		}
		return null;
	}

	public void deleteDoctor(Long id) {
		doctorList.remove(id);
	}
}
