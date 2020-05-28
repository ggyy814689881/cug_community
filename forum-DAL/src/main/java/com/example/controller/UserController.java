package com.example.controller;


import java.io.Serializable;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;


@RestController
public class UserController extends BaseController {
	@RequestMapping(name = "get",path ="/login")
	public User Login(@RequestParam("id") Serializable id) {
		User user = userService.getById(id);
		return user;
	}
	
	@RequestMapping("/reg")
	public String reg(User user) {
		
		boolean flag = userService.save(user);
		System.out.println(flag);
		return "" + flag;
	}
}
