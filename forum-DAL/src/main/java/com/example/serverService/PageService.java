package com.example.serverService;

import com.example.vo.IpageVo;

public interface PageService {

	public IpageVo getIPage(int pn, int size, Long categoryId, Long userId,
			Integer level, Boolean recommend, String order);

}
