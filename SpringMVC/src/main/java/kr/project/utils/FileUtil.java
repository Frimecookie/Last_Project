package kr.project.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public final class FileUtil {
	
	public static boolean setDir(String path) {
		File file = new File(path);
		boolean isMkdir = false;
		if(!file.exists()) {
			isMkdir = file.mkdirs();
		}
		
		return isMkdir;
	}
	
	public static boolean isExist(String path) {
		File file = new File(path);
		return file.exists();
	}
	
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