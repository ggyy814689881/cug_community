package com.example.testng;

import com.example.lang.Result;

public class TestReg {
	public static void main(String[] args) {
		String data = "{\"status\":-1,\"msg\":\"两次密码不一致\",\"data\":null,\"action\":null}";
		Result result = new Result();
		data = data.substring(1, data.length()-1);
		String[] datas = data.split(",");
		for(int i=0;i<datas.length;i++) {
			datas[i] = datas[i].substring(datas[i].indexOf(':')+1);
			datas[i] = datas[i].replaceAll("\"", "");
			System.out.println(datas[i]);
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
		System.out.println(result.getData());
		System.out.println(result.getAction());
		System.out.println(result.getMsg());
		System.out.println(result.getStatus());
	}
}
