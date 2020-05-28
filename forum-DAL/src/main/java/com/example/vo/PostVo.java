package com.example.vo;

import java.io.Serializable;

import com.example.entity.Post;

import lombok.Data;
@Data
public class PostVo extends Post implements Serializable{
	private Long authorId;
	private String authorName;
	private String authorAvatar;
	private String categoryName;
}
