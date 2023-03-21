package kr.project.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.project.utils.FileUtil;

@Service
public class FileUploadService {

	private final static String SAVE_DIR = "/home/smhrd/img/mung/";
	private final static String EXTERNAL_DIR = "/resources/mung/";
	
	// IMG 파일 업로드 
	public HashMap<String, Object> uploadFile(MultipartHttpServletRequest req) {
		HashMap<String, Object> resMap = new HashMap<String, Object>();
		long curTimeStamp = System.currentTimeMillis();
		FileUtil.setDir(SAVE_DIR);
		
		if(!FileUtil.isExist(SAVE_DIR)) {
			resMap.put("code", "FAIL");
			resMap.put("msg", "업로드에 실패하였습니다.\n다시 시도하여 주시기 바랍니다.");
			return resMap;
		}
		
		try {			
			Iterator<String> itr =  req.getFileNames();
        	
        	if(itr.hasNext()) {        		        		
        		List<MultipartFile> mpf = req.getFiles((String) itr.next());
        		
        		for(int i = 0; i < mpf.size(); i++) {
        			String fileFullName = mpf.get(i).getOriginalFilename();
          			File file = new File(SAVE_DIR + fileFullName);
          		
        			String fileName = FilenameUtils.getBaseName(mpf.get(i).getOriginalFilename());
        			String fileType = fileFullName.substring(fileFullName.lastIndexOf(".")+1, fileFullName.length());
            		
        			String uniqFileNm = curTimeStamp + "." + fileType;
          			file = new File(SAVE_DIR + uniqFileNm);          				
          			String fullPath = file.getAbsolutePath();
          			String externalPath = EXTERNAL_DIR + uniqFileNm;
          			
          			System.out.println("FILE UPLOAD DETACT!");
          			System.out.println("FILE NAME ==> " + fileName);
          			System.out.println("FILE PATH ==> " + file.getAbsolutePath());

          			mpf.get(i).transferTo(file);	// 파일 전송
          			
          			resMap.put("code", "OK");
          			resMap.put("msg", "OK");
          			resMap.put("internalPath", fullPath);
          			resMap.put("externalPath", externalPath);
           	 	}           	         		
        	}        	        				
		} catch (IOException e) {
			e.printStackTrace();
			resMap.put("code", "FAIL");
			resMap.put("msg", "업로드에 실패하였습니다.\n다시 시도하여 주시기 바랍니다.");
		}
		return resMap;
	}
}
