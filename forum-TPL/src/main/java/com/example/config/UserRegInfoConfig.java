package com.example.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.example.entity.User;
import com.example.vo.regInfo;

import lombok.Data;
@Data
@Component
@ConfigurationProperties(prefix = "wq.userreginfo")
public class UserRegInfoConfig {
	private List<User> users;
	private List<regInfo> reginfos;
	
	
	
}
