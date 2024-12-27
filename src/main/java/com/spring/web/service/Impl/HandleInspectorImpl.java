package com.spring.web.service.Impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.logging.log4j.CloseableThreadContext.Instance;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class HandleInspectorImpl implements HandlerInterceptor{
	

	@Override
	public boolean preHandle(HttpServletRequest httpRequest, HttpServletResponse response, Object handler) throws Exception {

	

		System.err.print("Method Type: ");
		System.out.println(httpRequest.getMethod());
		System.err.print("Method Type: ");
		System.err.print("AuthType: ");
		System.out.println(httpRequest.getAuthType());
		System.err.print("RequestURL: ");
		System.out.println(httpRequest.getRequestURL());
		System.err.print("RequestURI/PATH: ");
		System.out.println(httpRequest.getRequestURI());
		System.err.print("Query String/URL Parameter: ");
		System.out.println(httpRequest.getQueryString());
		System.err.print("AuthType: ");
		System.out.println(httpRequest.getAuthType());
		System.err.print("Session: ");
		System.out.println(httpRequest.getSession());

		/*
		 * otomasyon Enumeration<String> headerNames = httpRequest.getHeaderNames();
		 * 
		 * if (headerNames != null) { while (headerNames.hasMoreElements()) { String
		 * headerName = headerNames.nextElement(); Enumeration<String> headerValues =
		 * httpRequest.getHeaders(headerName); System.out.print("1. : " + headerName +
		 * " "); while (headerValues.hasMoreElements()) { System.out.println("Value: " +
		 * headerValues.nextElement()); } } } else {
		 * System.out.println("No headers available."); }
		 */

		System.err.println("Headers: ");
		System.out.println("   1. Host: " + httpRequest.getHeader("HOST"));
		System.out.println("   2. ContentType: " + httpRequest.getHeader("Content-Type"));
		System.out.println("   3. Authorization " + httpRequest.getHeader("Authorization"));
		System.out.println("   4. User-Agent: " + httpRequest.getHeader("User-Agent"));
		System.out.println("   5. Host: " + httpRequest.getHeader("HOST"));
		System.out.println("   6. Accept: " + httpRequest.getHeader("Accept"));
		System.out.println("   7. Accept-Language: " + httpRequest.getHeader("Accept-Language"));
		System.out.println("   8. Accept-Encoding: " + httpRequest.getHeader("Accept-Encoding"));
		System.out.println("   9. x-forwarded-for: " + httpRequest.getHeader("x-forwarded-for"));
		System.out.println("   10. connection: " + httpRequest.getHeader("connection"));
		System.out.println("   11. cookie: " + httpRequest.getHeader("cookie"));
		/* Clonable ile Deep Clone (instate) yap, öyle kullan, ya da hiç kullanma
		System.err.println("Request Body");
		ServletInputStream stream = httpRequest.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		StringBuilder requestBody = new StringBuilder();
		String line;
		
		while((line = reader.readLine()) != null) {
			requestBody.append(line + "\n");
		}
		
		System.out.print(requestBody);
		*/
		return true;
	
	
	}

}
