package com.example.demo.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Appointment;

@Service
public class AppointmentService {
	private final Map<Long, Appointment> appointmentList = new HashMap<>();
	private Long currentId = 1L;

	public Appointment addAppointment(Appointment appointment) {
		appointment.setId(currentId++);
		appointmentList.put(appointment.getId(), appointment);
		return appointment;
	}

	public Collection<Appointment> getAllAppointments() {
		return appointmentList.values();
	}

	public Appointment getAppointmentById(Long id) {
		return appointmentList.get(id);
	}

	public Appointment updateAppointment(Long id, Appointment appointment) {
		if (appointmentList.containsKey(id)) {
			appointment.setId(id);
			appointmentList.put(id, appointment);
			return appointment;
		}
		return null;
	}

	public void deleteAppointment(Long id) {
		appointmentList.remove(id);
	}
}
