package com.example.serverService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.entity.Post;
import com.example.service.PostService;
import com.example.vo.PostVo;
@Component
@Service
public class OnePostImp implements OnePost{
	@Autowired
	PostService postService;
	@Override
	public PostVo selectOnePost(Long id) {
		return postService.selectOnePost(new QueryWrapper<Post>().eq("p.id", id));
	}
	
}
