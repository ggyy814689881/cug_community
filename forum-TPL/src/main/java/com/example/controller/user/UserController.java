package com.example.controller.user;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.controller.index.BaseController;
import com.example.entity.User;
import com.example.lang.Result;
import com.example.util.ValidationUtil;
import com.example.vo.regInfo;
import com.google.code.kaptcha.Producer;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;

@Controller
public class UserController extends BaseController{
    private static final String KAPTCHA_SESSION_KEY = "KAPTCHA_SESSION_KEY";

	@Autowired
	Producer producer;
	@GetMapping("/kaptcha")	
	public void kaptcha(HttpServletResponse resp) throws IOException {
		 // 验证码
        String text = producer.createText();
        BufferedImage image = producer.createImage(text);
        req.getSession().setAttribute(KAPTCHA_SESSION_KEY, text);
        resp.setHeader("Cache-Control", "no-store, no-cache");
        resp.setContentType("image/jpeg");
        ServletOutputStream outputStream = resp.getOutputStream();
        ImageIO.write(image, "jpg", outputStream);
	}
	@GetMapping("/user/login")
	public String toLogin() {
		return "html/user/login";
	}
	@ResponseBody
	@PostMapping("/user/login")
	public Result doLogin(String email, String password) {
		if(StrUtil.isEmpty(email) || StrUtil.isBlank(password)) {
            return Result.fail("邮箱或密码不能为空");
        }
		UsernamePasswordToken token = new UsernamePasswordToken(email, SecureUtil.md5(password));
		 try {
	            SecurityUtils.getSubject().login(token);

        } catch (AuthenticationException e) {
            if (e instanceof UnknownAccountException) {
                return Result.fail("用户不存在");
            } else if (e instanceof LockedAccountException) {
                return Result.fail("用户被禁用");
            } else if (e instanceof IncorrectCredentialsException) {
                return Result.fail("密码错误");
            } else {
                return Result.fail("用户认证失败");
            }
        }
		return Result.success().action("/");
	}
	
	@GetMapping("/user/reg")
	public String toReg() {
		return "html/user/reg";
	}
	@ResponseBody
	@PostMapping("/user/reg")
	public Result doReg(User user, regInfo reginfo) {
        ValidationUtil.ValidResult validResult = ValidationUtil.validateBean(user);
        if(validResult.hasErrors()) {
        	return Result.fail(validResult.getErrors());
        }
        if(!user.getPassword().equals(reginfo.getRepass())) {
        	return Result.fail("两次密码不一致");
        }

		String kaptcha = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
		System.out.println(kaptcha);
		if(reginfo.getVercode() == null || kaptcha == null ||
				!kaptcha.equalsIgnoreCase(reginfo.getVercode())) {
			return Result.fail("验证码不正确");
		}
		Result result = userService.Reg(user);
		return result.action("/user/login");
	}
}
