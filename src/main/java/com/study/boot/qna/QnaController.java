package com.study.boot.qna;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public ModelAndView setAdd(@Valid QnaVO qnaVO, BindingResult bindingResult, RedirectAttributes attributes, ModelAndView mv) throws Exception{
		log.info("setAdd {}",qnaVO);
		
		boolean check = bindingResult.hasErrors();
		List<FieldError> errors = bindingResult.getFieldErrors();
		
		if(check) {
			log.info("-------------검증에러발생---------------");
			mv.setViewName("qna/add");
		}else {
			qnaService.setAdd(qnaVO);
			mv.setViewName("redirect:/qna/detail?num="+qnaVO.getNum());
		}
		
		return mv;
	}
	
	@GetMapping("detail")
	public ModelAndView getDetail(QnaVO qnaVO, ModelAndView mv)throws Exception{
		qnaVO = qnaService.getDetail(qnaVO);
		
		mv.addObject("qnaVO", qnaVO);
		mv.setViewName("qna/detail");
		
		return mv;
	}
}
