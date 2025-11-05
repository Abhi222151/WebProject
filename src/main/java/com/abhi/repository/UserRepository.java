package com.abhi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.abhi.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	User findByUserId(Long userId);

}
