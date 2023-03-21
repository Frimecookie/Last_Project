package kr.project.utils;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public final class StringUtil {

	   /**
	    * 이전 페이지의 URL에서 페이지 이름을 추출하여 반환
	    * 이전 페이지의 URL이 유효하지 않으면 기본 페이지 이름을 반환
	    * Referer URL에서 Page경로만 떼서 반환한다.
	    * ex) input => http://localhost:8080/home.do, return => home.do
	    */

	public static String getBeforePage(String referer) {
		String domain = referer.split("://")[1];
		String pageNm = "";
		if(domain.contains("/")) {
			String path = domain.split("/")[1];
			pageNm = path;
		} else {
			pageNm = "home.do";
		}
		return pageNm;
	}
	
	/**
	 * JSON String을 HashMap<String, Object>로 변환
	 * @param body
	 * @return HashMap<String, Object>
	 */
	@SuppressWarnings("unchecked")
	public static HashMap<String, Object> convertStringToMap(String body) {
		HashMap<String, Object> resMap = new HashMap<String, Object>();
		JSONParser parser = new JSONParser();
		try {
			JSONObject root = (JSONObject) parser.parse(body);
			resMap = root;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return resMap;
	}
}