package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.User;
import com.example.lang.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2020-05-16
 */
public interface UserService extends IService<User> {
//	public User Login(Serializable id, String password);
	public Result Reg(User user);
}
