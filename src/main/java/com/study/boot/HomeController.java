package com.study.boot;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@Value("${my.default}")
	private String app;

	
	@Value("${my.message.hi}")
	private String message;
	
	private final Logger log = LoggerFactory.getLogger(HomeController.class); //homeController내에 로그 기록을 찍겠다.
//	private final Logger log = LoggerFactory.getLogger(this.getClass()); 
	
	@GetMapping("/")
	public String home(HttpSession session) throws Exception {
		log.info("========================================");
		log.info("message {}", message);
		log.info("default {}", app);
//		
//		List<QnaVO> ar = qnaMapper.getList();
//		
//		log.info("List : {} size {}", ar, ar.size()); //중괄호 안에 ar을 넣어라

		SecurityContext context = (SecurityContext)session.getAttribute("SPRING_SECURITY_CONTEXT");
		
		if(context!=null) {
			log.info("SecurityContext => {}", context);
		}
		
		return "index";
	}
}
