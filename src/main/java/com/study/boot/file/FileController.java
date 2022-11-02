package com.study.boot.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.study.boot.qna.QnaFileVO;
import com.study.boot.qna.QnaService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class FileController {

	@Autowired
	private QnaService qnaService;

	@GetMapping("resources/down/{path}")
	public ModelAndView fileDown(@PathVariable String path, QnaFileVO fileVO)throws Exception{
		log.info("fileDown controller path {} :  filenum {}", path, fileVO.getFileNum());
		
		if(path.equals("qna")) {
			fileVO = qnaService.getQnaFile(fileVO);
			log.info("qnafile {}", fileVO);
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("path", path);
		mv.addObject("fileVO", fileVO);
		mv.setViewName("fileView");
		
		return mv;
	}
}
