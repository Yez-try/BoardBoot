package com.study.boot.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MemberService {

	@Autowired
	private MemberMapper mapper;
	@Autowired
	private PasswordEncoder encoder;
	
	public int setJoin(MemberVO memberVO) throws Exception{
		//멤버인서트
		memberVO.setPassword(encoder.encode(memberVO.getPassword()));
		int result = mapper.setJoin(memberVO);
		log.info("멤버인서트{}",result);
		//롤인서트
		if(result==1) {
			MemberRoleVO memberRoleVO = new MemberRoleVO();
			memberRoleVO.setId(memberVO.getId());
			memberRoleVO.setNum(3);
			result = mapper.setRole(memberRoleVO);
			log.info("셋롤{}",result);
			
		}
		
		return result;
	}
}
