//package com.wmx;
//
//import org.testng.annotations.Test;
//
//import com.wmx.Handler.CalculateTicket;
//import com.wmx.bean.CPackage;
//import com.wmx.bean.Ticket;
//import com.wmx.controller.CConsignUtils;
//
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.ui.ExtendedModelMap;
//import org.springframework.ui.Model;
//import org.springframework.web.context.WebApplicationContext;
//
//
//
//@SpringBootTest(classes = LuggageTransportApplication.class)
//public class SpringBootLuggageTests extends AbstractTestNGSpringContextTests {
//
//	@Autowired
//	private WebApplicationContext webApplicationContext;
//
//	private MockMvc mockMvc;
//
//	@BeforeClass
//	public void setup() {
//		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//	}
////	java.lang.AssertionError: Content type expected:<application/json> but was:<text/html;charset=UTF-8>
//	//测试票价计算
//	//测试行李计算
////	@Autowired
////	CConsignUtils consign;
//	
//	@Test
//	public void testLuggage() throws Exception {
//		List<CPackage> cpackages = new ArrayList<>();
//		List<Ticket> tickets = new ArrayList<>();
//		Double[] totolPrice = {0.0,567.0,1050.0,5000.0,6900.0,350.0,0.0,500.0,
//				1000.0,1500.0,0.0,7500.0,5000.0,2500.0,2500.0};
//		//1 行李属性无输入 费用预测值无效null
//		cpackages.add(new CPackage(null,null,null,null,0.0));
//		tickets.add(new Ticket(1,"北京","重庆","经济舱","婴儿",1,0.0));
//		//2 非法行李尺寸输入 国内 费用预测值无效null
//		cpackages.add(new CPackage(0.0,0.0,0.0,0.0,567.0));
//		tickets.add(new Ticket(2,"武汉","重庆","经济舱","成人",0,567.0));
//		//3 行李尺寸过大 国内 费用预测值无效null
//		cpackages.add(new CPackage(101.0,66.0,44.0,0.0,1050.0));
//		tickets.add(new Ticket(3,"上海","重庆","头等舱","成人",0,1050.0));
//		//4 非法行李尺寸输入 国际 费用预测值无效null
//		cpackages.add(new CPackage(0.0,0.0,0.0,0.0,5000.0));
//		tickets.add(new Ticket(4,"北京","纽约","明珠经济舱","成人",0,5000.0));
//		//5 行李尺寸过大 国际 费用预测值无效null
//		cpackages.add(new CPackage(100.0,60.0,50.0,33.0,6900.0));
//		tickets.add(new Ticket(5,"上海","纽约","头等舱","成人",0,6900.0));
//		//6 行李尺寸在正常范围内，重量输入为1kg不在区间[2,32]内，费用预测值无效null 
//		cpackages.add(new CPackage(90.0,30.0,30.0,1.0,350.0));
//		tickets.add(new Ticket(6,"上海","重庆","经济舱","成人",0,350.0));
//		//7 国内，行李尺寸、重量在正常范围内，婴儿，行李超重
//		cpackages.add(new CPackage(90.0,30.0,30.0,11.0,0.0));
//		Ticket ticket = new Ticket(7,"北京","重庆","头等舱","婴儿",0,0.0);
//		tickets.add(ticket);
//		//8 国内，行李尺寸、重量在正常范围内，成人，经济舱，行李超重
//		cpackages.add(new CPackage(90.0,30.0,30.0,21.0,500.0));
//		ticket = new Ticket(8,"北京","重庆","经济舱","成人",0,500.0);
//		tickets.add(ticket);
//		//9 国内，行李尺寸、重量在正常范围内，成人，商务舱，行李超重
//		cpackages.add(new CPackage(90.0,30.0,30.0,31.0,1000.0));
//		ticket = new Ticket(9,"北京","重庆","商务舱","成人",0,1000.0);
//		tickets.add(ticket);
//		//10 国内，行李尺寸、重量在正常范围内，成人，商务舱，行李超重
//		cpackages.add(new CPackage(90.0,30.0,30.0,9.0,1500.0));
//		ticket = new Ticket(10,"北京","重庆","头等舱","成人",0,1500.0);
//		tickets.add(ticket);
//		CalculateTicket.calculateTicketPrice(ticket);
//		//11 国际，行李尺寸、重量在正常范围内，婴儿，行李超重
//		cpackages.add(new CPackage(90.0,30.0,30.0,10.0,0.0));
//		ticket = new Ticket(11,"北京","纽约","经济舱","婴儿",0,0.0);
//		tickets.add(ticket);
//		//12 国际，行李尺寸、重量在正常范围内，成人，非经济舱，3件行李及三件以上
//		cpackages.add(new CPackage(90.0,30.0,30.0,10.0,7500.0));
//		ticket = new Ticket(12,"北京","纽约","头等舱","成人",0,7500.0);
//		tickets.add(ticket);
//		//13 国际，行李尺寸、重量在正常范围内，成人，明珠经济舱，2件行李及2件以下，行李超过23kg
//		cpackages.add(new CPackage(90.0,30.0,30.0,24.0,5000.0));
//		ticket = new Ticket(13,"北京","纽约","明珠经济舱","成人",0,5000.0);
//		tickets.add(ticket);
//		//14 国际，行李尺寸、重量在正常范围内，成人，经济舱，1件行李，行李超过23kg
//		cpackages.add(new CPackage(90.0,30.0,30.0,24.0,2500.0));
//		ticket = new Ticket(14,"北京","纽约","经济舱","成人",0,2500.0);
//		tickets.add(ticket);
//		//15 国际，行李尺寸、重量在正常范围内，成人，经济舱，2件行李及2件以上
//		cpackages.add(new CPackage(90.0,30.0,30.0,10.0,2500.0));
//		ticket = new Ticket(15,"北京","纽约","经济舱","成人",0,2500.0);
//		tickets.add(ticket);
//		Double[] expected = {null,null,null,null,null,null,7.5,507.5,
//				1007.5,1507.5,375.0,7875.0,5037.5,2537.5,2875.0};
//		for(int i=0;i<cpackages.size();i++) {
//			Model model = new ExtendedModelMap();
//			CConsignUtils consign = new CConsignUtils();
//			if(i==9) {
//				consign.addPackages(new CPackage(90.0,30.0,30.0,32.0,1500.0));
//			}
//			if(i==10) {
//				CalculateTicket.calculateTicketPrice(ticket);
//			}
//			if(i==11) {
//				consign.setLuggageNums(2);
//			}
//			if(i==14) {
//				consign.setLuggageNums(1);
//			}
//			consign.setTotolPrice(totolPrice[i]);
//			consign.Calculate(cpackages.get(i), tickets.get(i), model);
//			Double actull = (Double) model.getAttribute("totolPrice");
//			System.out.println(actull);
//			Assert.assertEquals(actull, expected[i]);
//		}
//		
//	}
////	@Test
////	public void testEmployee() throws Exception {
////		//1
////	    RequestBuilder request = MockMvcRequestBuilders.post("/package")
////	            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
////	            .param("from","北京").param("to","重庆")
////	            .param("shipSpace","经济舱").param("travellerType","婴儿")
////	            .param("vip","1");
////	    MvcResult mvcResult = mockMvc.perform(request).andReturn();
////	    int status = mvcResult.getResponse().getStatus();
////	    System.out.println("返回状态码：" + status);
////	    System.out.println("分界线-------------------");
////	    
////	    request = MockMvcRequestBuilders.post("/package")
////	            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
////	            .param("from","北京").param("to","新加坡")
////	            .param("shipSpace","头等舱").param("travellerType","成人")
////	            .param("vip","0");
////	    mvcResult = mockMvc.perform(request).andReturn();
////	    status = mvcResult.getResponse().getStatus();
////	    System.out.println("返回状态码：" + status);
////	    System.out.println("分界线-------------------");
////	    
////	    request = MockMvcRequestBuilders.post("/package")
////	            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
////	            .param("from","北京").param("to","纽约")
////	            .param("shipSpace","商务舱").param("travellerType","成人")
////	            .param("vip","1");
////	    mvcResult = mockMvc.perform(request).andReturn();
////	    status = mvcResult.getResponse().getStatus();
////	    System.out.println("返回状态码：" + status);
////	    System.out.println("分界线-------------------");
////	    
////	    request = MockMvcRequestBuilders.post("/package")
////	            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
////	            .param("from","上海").param("to","重庆")
////	            .param("shipSpace","明珠经济舱").param("travellerType","成人")
////	            .param("vip","1");
////	    mvcResult = mockMvc.perform(request).andReturn();
////	    status = mvcResult.getResponse().getStatus();
////	    System.out.println("返回状态码：" + status);
////	    System.out.println("分界线-------------------");
////	    
////	    request = MockMvcRequestBuilders.post("/package")
////	            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
////	            .param("from","上海").param("to","新加坡")
////	            .param("shipSpace","经济舱").param("travellerType","成人")
////	            .param("vip","1");
////	    mvcResult = mockMvc.perform(request).andReturn();
////	    status = mvcResult.getResponse().getStatus();
////	    System.out.println("返回状态码：" + status);
////	    System.out.println("分界线-------------------");
////	    
////	    request = MockMvcRequestBuilders.post("/package")
////	            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
////	            .param("from","上海").param("to","纽约")
////	            .param("shipSpace","明珠经济舱").param("travellerType","成人")
////	            .param("vip","0");
////	    mvcResult = mockMvc.perform(request).andReturn();
////	    status = mvcResult.getResponse().getStatus();
////	    System.out.println("返回状态码：" + status);
////	    System.out.println("分界线-------------------");
////	    
////	    request = MockMvcRequestBuilders.post("/package")
////	            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
////	            .param("from","武汉").param("to","重庆")
////	            .param("shipSpace","头等舱").param("travellerType","成人")
////	            .param("vip","1");
////	    mvcResult = mockMvc.perform(request).andReturn();
////	    status = mvcResult.getResponse().getStatus();
////	    System.out.println("返回状态码：" + status);
////	    System.out.println("分界线-------------------");
////	    
////	    request = MockMvcRequestBuilders.post("/package")
////	            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
////	            .param("from","武汉").param("to","新加坡")
////	            .param("shipSpace","商务舱").param("travellerType","成人")
////	            .param("vip","0");
////	    mvcResult = mockMvc.perform(request).andReturn();
////	    status = mvcResult.getResponse().getStatus();
////	    System.out.println("返回状态码：" + status);
////	    System.out.println("分界线-------------------");
////	    
////	    request = MockMvcRequestBuilders.post("/package")
////	            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
////	            .param("from","武汉").param("to","纽约")
////	            .param("shipSpace","经济舱").param("travellerType","成人")
////	            .param("vip","0");
////	    mvcResult = mockMvc.perform(request).andReturn();
////	    status = mvcResult.getResponse().getStatus();
////	    System.out.println("返回状态码：" + status);
////	    System.out.println("分界线-------------------");
////	}
//
//	
//}
