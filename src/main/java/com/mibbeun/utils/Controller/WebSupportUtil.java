package com.mibbeun.utils.Controller;
import java.io.IOException;
import java.net.URLEncoder;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class WebSupportUtil {
	
	private final static char SEPERATOR = '~';
	public static final String HEADER_INFO_UNKNOWN = "unknown";

	public static void setDisposition(String filename, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String browser = getBrowser(request);

		String dispositionPrefix = "attachment; filename=";
		String encodedFilename = null;

		if ("MSIE".equals(browser)) {
			encodedFilename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", "%20");
		} else if ("Trident".equals(browser)) { // IE11 
			encodedFilename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", "%20");
		} else if ("Firefox".equals(browser)) {
			encodedFilename = "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\"";
		} else if ("Opera".equals(browser)) {
			encodedFilename = "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\"";
		} else if ("Chrome".equals(browser)) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < filename.length(); i++) {
				char c = filename.charAt(i);
				if (c > SEPERATOR) {
					sb.append(URLEncoder.encode("" + c, "UTF-8"));
				} else {
					sb.append(c);
				}
			}
			encodedFilename = sb.toString();
		} else {
			throw new IOException("Not supported browser");
		}

		response.setHeader("Content-Disposition", dispositionPrefix + encodedFilename);

		if ("Opera".equals(browser)) {
			response.setContentType("application/octet-stream;charset=UTF-8");
		}
	}
	
	public static String getBrowser(HttpServletRequest request) {
		String header = request.getHeader("User-Agent");
		if (header.indexOf("MSIE") > -1) {
			return "MSIE";
		} else if (header.indexOf("Trident") > -1) { // IE11 臾몄옄??源⑥쭚 諛⑹?
			return "Trident";
		} else if (header.indexOf("Chrome") > -1) {
			return "Chrome";
		} else if (header.indexOf("Opera") > -1) {
			return "Opera";
		}
		return "Firefox";
	}
	
	public static String getClientIp(HttpServletRequest request) { //NOPMD //NOSONAR
		String ip = request.getHeader("X-Forwarded-For");
		if (ip == null || ip.length() == 0 || HEADER_INFO_UNKNOWN.equalsIgnoreCase(ip)) { 
		    ip = request.getHeader("Proxy-Client-IP"); 
		} 
		if (ip == null || ip.length() == 0 || HEADER_INFO_UNKNOWN.equalsIgnoreCase(ip)) { 
		    ip = request.getHeader("WL-Proxy-Client-IP"); 
		} 
		if (ip == null || ip.length() == 0 || HEADER_INFO_UNKNOWN.equalsIgnoreCase(ip)) { 
		    ip = request.getHeader("HTTP_CLIENT_IP"); 
		} 
		if (ip == null || ip.length() == 0 || HEADER_INFO_UNKNOWN.equalsIgnoreCase(ip)) { 
		    ip = request.getHeader("HTTP_X_FORWARDED_FOR"); 
		} 
		if (ip == null || ip.length() == 0 || HEADER_INFO_UNKNOWN.equalsIgnoreCase(ip)) { 
		    ip = request.getRemoteAddr(); 
		}
	    return ip;
	}
}