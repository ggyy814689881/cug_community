package com.example.vo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
@Data
public class CommentVos implements Serializable{
	
	public CommentVos(List<CommentVo> commentVos, Long totol, Long size, Long current) {
		super();
		this.commentVos = commentVos;
		this.totol = totol;
		this.size = size;
		this.current = current;
	}
	private static final long serialVersionUID = 1L;
	private List<CommentVo> commentVos;
	private Long totol;
	private Long size;
	private Long current;
}
