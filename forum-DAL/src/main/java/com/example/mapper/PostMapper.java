package com.example.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.Post;
import com.example.vo.PostVo;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 
 * @since 2020-05-16
 */
@Component
public interface PostMapper extends BaseMapper<Post> {
//@Param(Constants.WRAPPER)
	public IPage<PostVo> selectPosts(Page page, @Param(Constants.WRAPPER) QueryWrapper queryWrapper);

	public PostVo selectOnePost(@Param(Constants.WRAPPER) QueryWrapper<Post> wrapper);

	

}
