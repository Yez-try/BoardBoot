package com.study.boot.util;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class FileManager {
	
	@Value("${my.upload.file}")
	private String path;

	public String saveFile(MultipartFile multipartFile, String lastPath)throws Exception{
		//랜덤파일명+.확장자
		String fileName = UUID.randomUUID().toString();
		String oriName = multipartFile.getOriginalFilename();
		
		StringBuffer bf = new StringBuffer();
		
		
		bf.append(fileName);
		bf.append(oriName.substring(oriName.lastIndexOf(".")));
		log.info("fileName : {}", bf.toString());
		
		//filesave
		File file = new File(path+lastPath+"/", bf.toString());
		multipartFile.transferTo(file);
		
		return bf.toString();
	}
}
