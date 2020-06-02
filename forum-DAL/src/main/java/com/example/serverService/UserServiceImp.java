package com.example.serverService;

import java.util.Date;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.entity.AccountProfile;
import com.example.entity.User;
import com.example.lang.Result;
import com.example.service.UserService;

import cn.hutool.core.bean.BeanUtil;

@Component
@Service
public class UserServiceImp implements TplUserService{
	@Autowired
	UserService userService;
	@Override
	public Result Reg(User user) {
		if(user.getUsername().contains("select")) {
			return Result.fail("用户名含有非法的输入");
		}
		return userService.Reg(user);
	}
	@Override
	public AccountProfile login(String email, String password) {
		User user = userService.getOne(new QueryWrapper<User>().eq("email", email));
		if(user == null) {
			throw new UnknownAccountException();
		}
		if(!user.getPassword().equals(password)) {
			throw new IncorrectCredentialsException();
		}
		user.setLasted(new Date());
		userService.updateById(user);
		AccountProfile profile = new AccountProfile();
		BeanUtil.copyProperties(user, profile);
		return profile;
	}

}
