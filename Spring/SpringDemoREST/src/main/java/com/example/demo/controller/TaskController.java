package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Task;

@RestController
@RequestMapping("/tasks")
public class TaskController {

	private final List<Task> tasks = new ArrayList<>();
	
	@PostMapping
	public void addTask(@RequestBody Task task) {
		tasks.add(task);
	}
	
	@GetMapping
	public List<Task> getAllTasks(){
		return tasks;
	}
	
	@GetMapping("/{id}")
	public Task getTaskById(@PathVariable Integer id) {
		return tasks.stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null);
	}
	
	@DeleteMapping("/{id}")
	public void deleteTaskById(@PathVariable Integer id) {
		tasks.removeIf(t -> t.getId().equals(id));
	}
}
