package com.study.boot.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.study.boot.util.FileManager;
import com.study.boot.util.Pager;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class QnaService {
	@Autowired
	private QnaMapper qnaMapper;
	@Autowired
	private FileManager fileManager;
	
	public List<QnaVO> getList(Pager pager) throws Exception{
		pager.calRow(qnaMapper.getTotal(pager));
		return qnaMapper.getList(pager);
	}
	
	public int setAdd(QnaVO qnaVO) throws Exception{
		
		int result = qnaMapper.setAdd(qnaVO);
		
		MultipartFile[] files = qnaVO.getFile();
		
		
		
		if(files!=null) {				
			for(MultipartFile file: files) {
				
				QnaFileVO fileVO = new QnaFileVO();
				fileVO.setFileName(fileManager.saveFile(file, "qna"));
				fileVO.setNum(qnaVO.getNum());
				fileVO.setOriName(file.getOriginalFilename());
				
				qnaMapper.setFileAdd(fileVO);
			}
		}
		
		return result ;
	}
	
	public QnaVO getDetail(QnaVO qnaVO)throws Exception{
		return qnaMapper.getDetail(qnaVO);
	}
	
	public QnaFileVO getQnaFile(QnaFileVO qnaFileVO)throws Exception{
		return qnaMapper.getQnaFile(qnaFileVO);
	}
	
}
