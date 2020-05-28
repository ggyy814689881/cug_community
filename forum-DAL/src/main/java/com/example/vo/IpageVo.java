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
	
	public IpageVo(List<PostVo> ipages, Long totol, Long size, Long current) {
		super();
		this.ipages = ipages;
		this.totol = totol;
		this.size = size;
		this.current = current;
	}

	public IpageVo() {
		super();
	}
	
}
