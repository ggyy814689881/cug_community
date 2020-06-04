package com.example.controller.index;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.vo.CommentVos;
import com.example.vo.IpageVo;
import com.example.vo.PostVo;

@Controller
public class PostController extends BaseController{
	@GetMapping("/category/{id:\\d*}")
	public String getCategory(@PathVariable("id") Long id, Model model) {
		model.addAttribute("currentCategoryId", id);
		IpageVo postVos = this.getPage(id,null,null,null,"created");	
		model.addAttribute("postVos", postVos);
		return "html/jie/category";
	}
	@GetMapping("/detail/{id:\\d*}")
	public String detail(@PathVariable("id") Long id,Model model) {
		PostVo post = onepost.selectOnePost(id);
		Assert.notNull(post, "文章不存在或者已经被删除");
		int pn = ServletRequestUtils.getIntParameter(req, "pn", 1);
		int size = ServletRequestUtils.getIntParameter(req, "size", 2);
		CommentVos commentVos = this.pageService.getCommentVos(pn, size, post.getId(), null, "created");
		System.out.println(commentVos.getSize());
		model.addAttribute("post", post);
		model.addAttribute("commentVos", commentVos);
		model.addAttribute("currentCategoryId", post.getCategoryId());
		return "html/jie/detail";
	}
}
