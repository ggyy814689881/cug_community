package com.example.service.impl;

import com.example.entity.Post;
import com.example.mapper.PostMapper;
import com.example.service.PostService;
import com.example.vo.PostVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 
 * @since 2020-05-16
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService {
	@Autowired
	PostMapper postMapper;
	@Override
	public PostVo selectOnePost(QueryWrapper<Post> wrapper) {
		return postMapper.selectOnePost(wrapper);
	}

}
