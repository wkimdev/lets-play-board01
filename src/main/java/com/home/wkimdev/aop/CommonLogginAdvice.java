package com.home.wkimdev.aop;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;

import com.home.wkimdev.OrderLogModel;

/*
 * 공통 로깅 처리 aop 
 */
public class CommonLogginAdvice {

	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable {

		// 공통 기능이 적용되는 메서드가 어떤 메서드인지 출력하기 위해 메서드명을 얻어옴
		String signatureStr = joinpoint.getSignature().toShortString();
		System.out.println(" [ 서비스 " + signatureStr + " 시작 ]"); // 메서드 실행
		
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd-hhmmss");
		
		// 주문 확인 중, 스키줄시간 : yyyymmddhhmmss, 주문 갯수 0개
		OrderLogModel orderLog = new OrderLogModel();
		orderLog.setActionName("주문 확인 중")
				.setScheduleTime(dateFormat.format(currentDate))
				.setOrderCount("주문 갯수 0 개 ");

		// 공통기능
		// System.out.println("핵심 기능 전에 실행 할 공통 기능입니다. ");

		try {
			Object obj = joinpoint.proceed(); // 핵심 기능 실행 (다음 advice를 수행) 
			return obj;
		} finally {
			// 공통기능
			// System.out.println("핵심 기능 후에 실행 할 공통 기능입니다. " + System.currentTimeMillis());
			
			// TODO: 최종 로그를 담는다. 
			
			// 최종 로그를 출력한다. 
			orderLog.getOrderLogModel();

			System.out.println(" [ 서비스 " + signatureStr + " 끝 ]");
		}
	}

}
