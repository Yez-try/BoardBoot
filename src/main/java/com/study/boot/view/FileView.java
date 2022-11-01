package com.study.boot.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class FileView extends AbstractView{

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
//		log.info("======================================");
//		log.info("File DownLoad view");
//		
//		
//		//컨트롤러에서 mv.addObject("fileVO", fileVO);로 보내준 qnafileVO가 model 에 담겨 전달된다.
//		QnaFileVO fileVO = (QnaFileVO)model.get("fileVO");
//		String path = (String)model.get("path");
//		log.info("---------------------------------------");
//		log.info("qnaFileVO:{}",fileVO);
//		
//		File file = new File(base+path+"/", fileVO.getFileName());
//		
//		//한글 처리 
//		response.setCharacterEncoding("UTF-8");
//		
//		//총 파일의 크기
//		response.setContentLengthLong(file.length());//file.length()는 파일의 크기를 뜻한다.
//		
//		//다운로드시 파일의 이름을 인코딩
//		String oriName = URLEncoder.encode(fileVO.getOriName(), "UTF-8");
//		
//		//header 설정 (부가적인 정보 의미, 이파일이 뭐고, 어떤 형식이다를 뜻함)
//		response.setHeader("Content-Disposition", "attachment;filename=\""+oriName+"\"");
//		response.setHeader("Content-Transfer-Encoding", "binary");//전송할 때의 파일 형식을 의미 (text가 아닌 이진 파일이라고 알려줌)
//		
//		// HDD에서 파일을 읽고(FileInputStram으로 읽어옴)
//		FileInputStream fi = new FileInputStream(file);
//		// Client로 전송준비
//		OutputStream os = response.getOutputStream(); //클라이언트로 연결된 스트림을 가져온다.
//		
//		//실제 전송하기
//		FileCopyUtils.copy(fi, os);
//		
//		//자원 해제
//		os.close();
//		fi.close();
		
	}

}
