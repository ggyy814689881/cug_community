package com.example.controller.index;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.ServletRequestUtils;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.serverService.OnePost;
import com.example.serverService.PageService;
import com.example.serverService.TplUserService;
import com.example.vo.IpageVo;


public class BaseController {
	@Autowired
	protected HttpServletRequest req;
	@Reference
	PageService pageService;
	@Reference
	OnePost onepost;
	@Reference
	protected TplUserService userService;
	
	public IpageVo getPage(Long categoryId, Long userId,
			Integer level, Boolean recommend, String order) {
		int pn = ServletRequestUtils.getIntParameter(req, "pn", 1);
		int size = ServletRequestUtils.getIntParameter(req, "size", 2);
		//调用数据访问层服务,实现分页
		IpageVo postVos = pageService.getIPage(pn,size,categoryId,userId,level,recommend,"created");
		return postVos;
	}

}
