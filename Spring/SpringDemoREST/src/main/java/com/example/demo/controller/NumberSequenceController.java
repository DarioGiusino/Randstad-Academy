package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumberSequenceController {
	
	@GetMapping("/sequence/{n}")
	public List<Integer> getNumberSequence(@PathVariable Integer n){
		List<Integer> nums = new ArrayList<>();
		for(int i = 1; i <= n; i++) {
			nums.add(i);
		}
		return nums;
	}
}
