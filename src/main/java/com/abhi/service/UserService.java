package com.abhi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.abhi.VO.Department;
import com.abhi.VO.ResponseTemplateVO;
import com.abhi.entity.User;
import com.abhi.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;

	public User createUser(User user) {
		return userRepository.save(user);
	}

	public User getUser(Long userId) {
		// TODO Auto-generated method stub
		return userRepository.findByUserId(userId);
	}

	public ResponseTemplateVO getUserWithDepartment(Long userId) {
		// TODO Auto-generated method stub

		ResponseTemplateVO vo = new ResponseTemplateVO();
		User user = userRepository.findByUserId(userId);
        // calling department microservice using rest template.
		// DEPARTMENT-SERVICE
		Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(),
				Department.class);
		
		vo.setUser(user);
		vo.setDepartment(department);
		 
		return vo;
	}

}
