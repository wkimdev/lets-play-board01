package com.home.wkimdev.aop;

import org.aspectj.lang.ProceedingJoinPoint;

import com.home.wkimdev.OrderLogModel;
import com.home.wkimdev.loggging.StandardLogUtils;

/*
 * 서비스 로깅 처리 aop 
 */
public class ServiceLoggingAdvice {
	
	/**
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 */
	public Object invoke(ProceedingJoinPoint joinpoint) throws Throwable {

		// 이전 스레드에서 적재한 로그 모델을 가져와 나머지 필드를 입력한다. 
		final OrderLogModel orderLog = StandardLogUtils.getLog();
		
//		final StandardLogModel log = StandardLogUtils.getLog().createChildLog()
//				.setRegReqTime(new Date());
//		fillLog(log, joinPoint);
		
		String signatureStr = joinpoint.getSignature().toShortString();
		System.out.println(signatureStr + "시작"); // 메서드 실행

		// 공통기능
		System.out.println("핵심 기능 전에 실행 할 공통 기능입니다. " + System.currentTimeMillis());

		try {
			Object obj = joinpoint.proceed(); // 핵심 기능 실행
			return obj;
		} finally {
			// 공통기능
			System.out.println("핵심 기능 후에 실행 할 공통 기능입니다. " + System.currentTimeMillis());

			System.out.println(signatureStr + "끝");
		}
	}
	
	/*
	 * filllog method
	 */
	public Object filllog(final OrderLogModel log, final ProceedingJoinPoint joinPoint) {
		
		// 서비스명 및 클래스명 적재 
		
		return null;
	} 

}
