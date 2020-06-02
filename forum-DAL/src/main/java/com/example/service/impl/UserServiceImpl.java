package com.example.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.User;
import com.example.lang.Result;
import com.example.mapper.UserMapper;
import com.example.service.UserService;

import cn.hutool.crypto.SecureUtil;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 
 * @since 2020-05-16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

	@Override
	public Result Reg(User user) {
		int count = this.count(new QueryWrapper<User>().
				eq("email", user.getEmail()).
				or().
				eq("username", user.getUsername()));
		if(count>0) {
			return Result.fail("用户名或者邮箱已经被占用");
		}
		User temp = new User();
		temp.setEmail(user.getEmail());
		temp.setUsername(user.getUsername());
		temp.setPassword(SecureUtil.md5(user.getPassword()));
		
		temp.setAvatar("/res/images/avatar/default.png");
		temp.setCreated(new Date());
		temp.setVipLevel(0);
		temp.setPoint(0);
		temp.setCommentCount(0);
		temp.setPostCount(0);
		this.save(temp);
		return Result.success();
	}


}
