package kr.project.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public final class FileUtil {
	
	 // 지정된 경로에 디렉토리를 생성
	public static boolean setDir(String path) {
		File file = new File(path);
		boolean isMkdir = false;
		if(!file.exists()) {
			isMkdir = file.mkdirs();
		}
		
		return isMkdir;
	}
	
	// 해당 경로의 파일, 디렉토리의 존재 여부 확인
	public static boolean isExist(String path) {
		File file = new File(path);
		return file.exists();
	}
	
	 // 입력으로부터 데이터를 읽어서 파일로 저장하는 기능
	public static void saveFile(String path, String fileNm) {
		File file = new File(path, fileNm);
		try {
			int data;
			FileOutputStream fos = new FileOutputStream(file);
			while((data = System.in.read()) != -1) {
				fos.write(data);
            }
			fos.flush();
            fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}