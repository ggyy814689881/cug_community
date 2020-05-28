package com.example.service;

import com.example.entity.Post;
import com.example.vo.PostVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2020-05-16
 */
public interface PostService extends IService<Post> {
	public PostVo selectOnePost(QueryWrapper<Post> wrapper); 
}
