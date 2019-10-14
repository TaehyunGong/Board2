package com.taehyun.board.Common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.IOUtils;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.core.io.Resource;

public class FileLib {

//	private static final Log LOGGER = LogFactory.getLog(FileLib.class);
	private String filePath = "";
	
	//업로드 및 다운로드할 파일의 경로를 필수로 받는다.
	public FileLib(Resource path) throws IOException {
		System.out.println("FileLib File Upload and Download Path : " + path.getURL().getPath());
		this.filePath = path.getURL().getPath(); 
	}

	/**
	 * @param file
	 * @return 파일 명 + 확장자
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public String uploadFile(File file) throws FileNotFoundException, IOException {
		
		//파일 원본 이름
		String fileName = fileNameGenerater(file.getName());
		
		byte[] bytes = IOUtils.toByteArray(new FileInputStream(file));
		
		byte fileData[] = bytes;
		FileOutputStream fos = new FileOutputStream(filePath + fileName);
        fos.write(fileData);
		
        System.out.println("업로드 완료");
        
		return fileName;
	}
	
	/**
	 * @param fileBytes
	 * @param originFileName
	 * @return 파일 명 + 확장자
	 * @throws IOException
	 * @description MultiPartFile의 getBytes()을 사용후 업로드
	 */
	public String uploadFile(byte[] fileBytes, String originFileName) throws IOException {
		//파일 원본 이름
		String fileName = fileNameGenerater(originFileName);
		
		FileOutputStream fos = new FileOutputStream(filePath + fileName);
        fos.write(fileBytes);
		
        System.out.println("업로드 완료");
        
		return fileName;
	}
	
	/**
	 * @return String
	 * @description 업로드 하기 위해 랜덤한 파일명을 생성
	 */
	public String fileNameGenerater(String originFileName) {
		//업로드 이름 랜덤으로 생성
		String random = String.valueOf((Math.random()*1000000) + System.currentTimeMillis());
		String fileName = random + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		
		//확장자를 업로드 이름에 삽입
		String ext = originFileName.substring( originFileName.lastIndexOf(".") + 1 );
		fileName = fileName + "." + ext; //확장자
		
		System.out.println("파일 원본 이름 : " + originFileName);
		System.out.println("업로드 파일 이름 : " + fileName);
		
		return fileName;
	}
	
	/**
	 * @return filePath
	 * @description 업로드 경로를 반환받는다. 
	 */
	public String getFilePath() {
		return filePath;
	}
	
}
