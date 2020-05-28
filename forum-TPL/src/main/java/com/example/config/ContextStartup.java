package com.example.config;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.context.ServletContextAware;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.entity.Category;
import com.example.serverService.ContextCategoryService;
@Service
@Component
public class ContextStartup implements ApplicationRunner,ServletContextAware{

	@Reference
	ContextCategoryService contextCategoryService;
	
	ServletContext servletContext;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		List<Category> categorys = contextCategoryService.getCategorys();
		servletContext.setAttribute("categorys", categorys);
		
	}
    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }	
}

