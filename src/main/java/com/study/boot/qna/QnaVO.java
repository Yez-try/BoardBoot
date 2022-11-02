package com.study.boot.qna;

import java.sql.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class QnaVO {
	private Long num;
	@NotBlank
	private String title;
	@NotBlank
	private String writer;
	@Size(min=10)
	private String contents;
	private Long hit;
	private Date regDate;
	private Long ref;
	private Long step;
	private Long depth;
	private MultipartFile[] file;
	private MultipartFile files;//아무래도 썸머노트랑 연결되는것 같다... 확인해보자
	private List<QnaFileVO> qnaFileVOs;
	
}
