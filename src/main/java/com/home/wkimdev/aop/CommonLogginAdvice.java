package com.home.wkimdev.aop;

import java.text.SimpleDateFormat;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.home.wkimdev.loggging.OrderLogModel;
import com.home.wkimdev.loggging.StandardLogUtils;

/*
 * 공통 로깅 처리 aop 
 */
public class CommonLogginAdvice {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CommonLogginAdvice.class);  

	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable {

		// 공통 기능이 적용되는 메서드가 어떤 메서드인지 출력하기 위해 메서드명을 얻어옴
		String signatureStr = joinpoint.getSignature().toShortString();
		System.out.println(" [ 서비스 " + signatureStr + " 시작 ]"); // 메서드 실행
		
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd-hhmmss");
		
		// 주문 확인 중, 스키줄시간 : yyyymmddhhmmss, 주문 갯수 0개
		OrderLogModel orderLog = new OrderLogModel();
		orderLog.setActionName("주문 확인 중(배치서비스)")
				.setScheduleTime(dateFormat.format(currentDate))
				.setOrderCount("주문 갯수 0 개 ");
		
		StandardLogUtils.setLog(orderLog);
		// 공통기능
		// System.out.println("핵심 기능 전에 실행 할 공통 기능입니다. ");

		try {
			return joinpoint.proceed(); // 핵심 기능 실행 (다음 advice를 수행) 
		} finally {
			// 공통기능
			// System.out.println("핵심 기능 후에 실행 할 공통 기능입니다. " + System.currentTimeMillis());
			
			// TODO: 최종 로그를 담고 출력한다. 
			final OrderLogModel finalLog = StandardLogUtils.getLog();
			finalLogPrint(finalLog);
			
			LOGGER.info(" [ 서비스 {} 끝 ]", signatureStr);
		}
	}
	
	/*
	 * final log 출력 
	 */
	private void finalLogPrint(OrderLogModel orderlog) {
		orderlog.getOrderLogModel();
	}

}
