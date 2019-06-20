package com.zr.demo.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zr.demo.dao.UserDao;
import com.zr.demo.model.User;
import com.zr.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    @Autowired  
    private UserDao userDao;  
	@Override
	public User selectUserById(Integer userId) {
		// TODO Auto-generated method stub
		return userDao.selectUserById(userId);
	}

	
}
