package com.example.serverService;

import com.example.entity.AccountProfile;
import com.example.entity.User;
import com.example.lang.Result;

public interface TplUserService {
	public Result Reg(User user);
	public AccountProfile login(String username, String password);
}
