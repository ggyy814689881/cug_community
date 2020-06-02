package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.example.config.UserRegInfoConfig;
import com.example.entity.User;
import com.example.lang.Result;
import com.example.vo.regInfo;

@SpringBootTest(classes = ForumTplApplication.class)
public class ForumTplApplicationTests extends AbstractTestNGSpringContextTests{
	@Autowired
	UserRegInfoConfig userRegInfoConfig;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;
	@BeforeClass
	@AutoConfigureMockMvc
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	@Test
	public void testByYaml() throws Exception {
		List<User> Users = userRegInfoConfig.getUsers();
		List<regInfo> regInfos = userRegInfoConfig.getReginfos();
		
		for(int i=0;i<Users.size();i++) {
			User user = Users.get(i);
			regInfo reginfo = regInfos.get(i);
			RequestBuilder request = MockMvcRequestBuilders.post("/user/reg")
		           .contentType(MediaType.APPLICATION_FORM_URLENCODED)
		           .param("username",user.getUsername()).param("password",user.getPassword())
		           .param("email",user.getEmail()).param("repass",reginfo.getRepass())
		           .param("vercode",reginfo.getVercode());
		    MvcResult mvcResult = mockMvc.perform(request).andReturn();
		    String data = mvcResult.getResponse().getContentAsString();
		    Result result = this.getResult(data);
		    System.out.println(result.getStatus());
		    System.out.println(reginfo.getMsg());
		    Assert.assertEquals(result.getStatus(), reginfo.getStatus());
		    Assert.assertEquals(result.getMsg(), reginfo.getMsg());

		}
	}

	public Result getResult(String data) {
		Result result = new Result();
		data = data.substring(1, data.length()-1);
		String[] datas = data.split(",");
		for(int i=0;i<datas.length;i++) {
			datas[i] = datas[i].substring(datas[i].indexOf(':')+1);
			datas[i] = datas[i].replaceAll("\"", "");
		}
		result.setStatus(Integer.parseInt(datas[0]));
		if(!datas[1].equals("null")) {
			result.setMsg(datas[1]);
		}
		if(!datas[2].equals("null")) {
			result.setData(datas[2]);
		}
		if(!datas[3].equals("null")) {
			result.setAction(datas[3]);
		}
		return result;
	}
}
