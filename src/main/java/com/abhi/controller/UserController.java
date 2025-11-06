package com.abhi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.VO.ResponseTemplateVO;
import com.abhi.entity.User;
import com.abhi.service.UserService;

@RestController
@RequestMapping("/test")
public class UserController {
 // Abhijeet Gupta
	@Autowired
	private UserService userService;

	/*
	 * @GetMapping("/") public String test() {
	 * 
	 * return "Abhijeet Gupta"; }
	 */

	@PostMapping("/xyz")
	public User createUser(@RequestBody User user) {

		return userService.createUser(user);

	}

	/*
	 * @GetMapping("/{id}") public User getUser(@PathVariable("id") Long userId) {
	 * 
	 * return userService.getUser(userId); }
	 */
	
	@GetMapping("/{id}")
	public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) {
		
		return userService.getUserWithDepartment(userId);
	}

}
