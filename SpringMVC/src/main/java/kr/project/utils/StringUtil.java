package kr.project.utils;

public final class StringUtil {

	/**
	 * Referer URL에서 Page경로만 떼서 반환한다.
	 * ex) input => http://localhost:8080/home.do, return => home.do
	 * @param referer
	 * @return
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
}