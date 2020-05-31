package com.example.controller.index;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.vo.IpageVo;



@Controller
public class IndexController extends BaseController{

	@GetMapping({"/","index"})
	public String getIndex(Model model) {
//		int pn = ServletRequestUtils.getIntParameter(req, "pn", 1);
//		int size = ServletRequestUtils.getIntParameter(req, "size", 2);
		//调用数据访问层服务,实现分页
		IpageVo postVos = this.getPage(null,null,null,null,"created");
		IpageVo IpostVos = this.getPage(null,null,1,null,"created");	
		model.addAttribute("postVos", postVos);
		model.addAttribute("IpostVos", IpostVos);
		model.addAttribute("currentCategoryId", 0);
		return "html/index";
	}
}
