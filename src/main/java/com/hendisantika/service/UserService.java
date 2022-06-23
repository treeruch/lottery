package com.hendisantika.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hendisantika.entity.UserLotter;

@Service
public class UserService {

	public List<UserLotter> findAll() {
		return new ArrayList<UserLotter>();
	}
}
