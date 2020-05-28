package com.example.vo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class IpageVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<PostVo> ipages;
	private Long totol;
	private Long size;
	private Long current;
	
}
