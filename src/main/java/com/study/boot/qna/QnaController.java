package com.study.boot.qna;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.study.boot.util.Pager;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("qna")
@Slf4j
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@GetMapping("list")
	public ModelAndView getList(Pager pager, ModelAndView mv)throws Exception{
		List<QnaVO> lst = qnaService.getList(pager);
		
		mv.addObject("lst", lst);
		mv.setViewName("qna/list");
		
		return mv;
	}
	
	@GetMapping("add")
	public String setAdd(@ModelAttribute QnaVO qnaVO)throws Exception{
		return "qna/add";
	}
	
	@PostMapping("add")
	public String setAdd(@Valid QnaVO qnaVO, BindingResult bindingResult) throws Exception{
		log.info("setAdd {}",qnaVO);
		qnaService.setAdd(qnaVO);
		
		boolean check = bindingResult.hasErrors();
		
		
		if(check) {
			log.info("-------------검증에러발생---------------");
		}
		
		return "redirect:/qna/list";
	}
}
