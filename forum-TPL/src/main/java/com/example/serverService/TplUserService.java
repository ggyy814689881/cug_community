package com.example.serverService;

import com.example.entity.User;
import com.example.lang.Result;
import com.example.shiro.AccountProfile;

public interface TplUserService {
	public Result Reg(User user);

	public AccountProfile login(String email, String password);

	
}
