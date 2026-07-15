package com.mibbeun;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Aspect
@Component
public class PostMappingAspect {
	
    // 모든 컨트롤러의 POST 메서드 실행 전
    @Before("execution(* com.mibbeun..*(..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void logBeforePostRequestMapping(JoinPoint joinPoint)  {
    	// System.out.println("========================================== ");
    	// System.out.println("공통 함수 실행: " + joinPoint.getSignature());
    	 ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    	 //ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
         if (attr != null) {
        	// attr.getSessionId()
             HttpServletRequest request = attr.getRequest();
             
             String IsHttpSession = request.getHeader("IsHttpSession");
             // if (!joinPoint.getSignature().getName().equals("SelectXuserOne"))
             if ((IsHttpSession != null) && IsHttpSession.equals("true"))
             {		 
	             HttpSession session = request.getSession(false); // false → 없으면 null 반환
	             if (session == null || session.getAttribute("USID") == null) {
	                // System.out.println("[SECURITY] 세션 없음 또는 사용자 인증 안됨");
	                 //throw new SessionNotFoundException("로그인이 필요합니다.");
	            	 // session = request.getSession(true);
	                 throw new RuntimeException("세션이 만료되었거나 로그인되지 않았습니다.");
	                 // 여기서 예외를 던져 컨트롤러 실행을 막을 수도 있음
	                 // throw new RuntimeException("로그인이 필요합니다.");
	            // } else if (session.getId().getAttribute("USID") == null){
		         } else {
	                // System.out.println("[SECURITY] 세션 사용자: " + session.getAttribute("USID"));
	             }
             }
             else {
            	 HttpSession session = request.getSession(true); 
             }
            	 
         }
         
    }
    /*

	// @RequestMapping 중 POST 메서드에만 적용
    @Before("@annotation(requestMapping) && args(..)")
    public void logBeforeRequestMapping(JoinPoint joinPoint,
                                        org.springframework.web.bind.annotation.RequestMapping requestMapping) {
        // RequestMethod.POST 여부 확인
        if (requestMapping.method().length > 0 &&
            requestMapping.method()[0] == RequestMethod.POST) {
            System.out.println("[LOG] @RequestMapping(POST) 실행 전: " + joinPoint.getSignature());
            for (Object arg : joinPoint.getArgs()) {
                System.out.println("[LOG] 요청 파라미터: " + arg);
            }
        }
    }	
    */
    
    // 모든 @PostMapping 메서드 실행 전에 동작
	/*
    @Before("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void beforePostMapping(JoinPoint joinPoint) {
        System.out.println("========================================== ");
        System.out.println("공통 함수 실행: " + joinPoint.getSignature());
             // 여기에 원하는 공통 로직 추가 (예: 로깅, 인증, 데이터 검증 등)
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println("[LOG] 요청 파라미터: " + arg);
        }        
    }
    */
}