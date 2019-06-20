package com.zr.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.zr.demo.model.User;

@Mapper
public interface UserDao {
	/**
	 * 	根据id来查询用户信息
	 * @param userId
	 * @return
	 */
	public User selectUserById(Integer userId);  
}
