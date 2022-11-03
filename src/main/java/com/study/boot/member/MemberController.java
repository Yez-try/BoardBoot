package com.study.boot.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("member")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("login")
	public void getLogin() throws Exception{
		
	}
	
	@GetMapping("join")
	public void setJoin() throws Exception{
		
	}
	
	@PostMapping("join")
	public void setJoin(MemberVO memberVO) throws Exception{
		int result = memberService.setJoin(memberVO);
	}
}
