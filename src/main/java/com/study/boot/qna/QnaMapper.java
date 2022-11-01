package com.study.boot.qna;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.study.boot.util.Pager;

@Mapper
public interface QnaMapper {
	public Integer getTotal(Pager pager) throws Exception;
	public List<QnaVO> getList(Pager pager)throws Exception;
	public Integer setAdd(QnaVO qnaVO) throws Exception;
	public Integer setFileAdd(QnaFileVO fileVO)throws Exception;

}
