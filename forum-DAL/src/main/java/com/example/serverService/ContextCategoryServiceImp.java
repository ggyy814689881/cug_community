package com.example.serverService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.entity.Category;
import com.example.service.CategoryService;

@Component
@Service
public class ContextCategoryServiceImp implements ContextCategoryService{
	@Autowired
	CategoryService categoryService;
	public List<Category> getCategorys(){
		List<Category> Categorys = categoryService.list(new QueryWrapper<Category>()
				.eq("status", 0));
//		System.out.println(Categorys.size());
		return Categorys;
	}
}
