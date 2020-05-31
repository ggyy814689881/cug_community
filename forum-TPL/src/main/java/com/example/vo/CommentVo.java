package com.example.vo;

import java.io.Serializable;

import com.example.entity.Comment;

import lombok.Data;
@Data
public class CommentVo extends Comment implements Serializable{
	private Long authorId;
	private String authorName;
	private String authorAvatar;
}
