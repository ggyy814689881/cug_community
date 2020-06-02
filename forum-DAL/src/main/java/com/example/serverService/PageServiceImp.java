package com.example.serverService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.Comment;
import com.example.entity.Post;
import com.example.mapper.CommentMapper;
import com.example.mapper.PostMapper;
import com.example.vo.CommentVo;
import com.example.vo.CommentVos;
import com.example.vo.IpageVo;
import com.example.vo.PostVo;

@Component
@Service
public class PageServiceImp implements PageService{
	@Autowired
	PostMapper postMapper;
	@Autowired
	CommentMapper commentMapper;
	@Override
	public IpageVo getIPage(int pn, int size, Long categoryId, Long userId, Integer level, Boolean recommend,
			String order) {
		Page page = new Page(pn,size);
		if(level==null) level = -1;
		QueryWrapper queryWrapper = new QueryWrapper<Post>()
				.eq(categoryId!=null, "category_id", categoryId)
				.eq(userId!=null, "user_id", userId)
				.eq(level==0, "level", 0)
				.gt(level > 0, "level", 0)
				.orderByDesc(order!=null, order);
		
		IPage<PostVo> ipage = postMapper.selectPosts(page, queryWrapper);
//		System.out.println(ipage.getSize());
		return new IpageVo(ipage.getRecords(),ipage.getTotal()
				,ipage.getSize(), ipage.getCurrent());
	}

	@Override
	public CommentVos getCommentVos(int pn, int size, Long postId, Long userId, String order) {
		Page page = new Page(pn,size);
		QueryWrapper queryWrapper = new QueryWrapper<Comment>()
				.eq(postId!=null, "post_id", postId)
				.eq(userId!=null, "user_id", userId)
				.orderByDesc(order!=null, order);
		IPage<CommentVo> commentVos=commentMapper.selectComments(page, queryWrapper);
//		System.out.println(commentVos.getTotal());
		return new CommentVos(commentVos.getRecords(),commentVos.getTotal(),
				commentVos.getSize(),commentVos.getCurrent());
	}


	


}
