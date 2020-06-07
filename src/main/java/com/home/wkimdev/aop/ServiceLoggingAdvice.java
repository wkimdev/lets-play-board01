package com.home.wkimdev.aop;

import org.aspectj.lang.ProceedingJoinPoint;

import com.home.wkimdev.loggging.OrderLogModel;
import com.home.wkimdev.loggging.StandardLogUtils;
import com.home.wkimdev.service.DeliveryService;
import com.home.wkimdev.service.OrderService;

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
		
		return filllog(orderLog, joinpoint);
	}
	
	/*
	 * filllog method
	 */
	public Object filllog(final OrderLogModel log, final ProceedingJoinPoint joinPoint) {
		
		// 서비스명 및 클래스명 적재
		String serviceName = null;

		final Class<?> type = joinPoint.getTarget().getClass();
		if (OrderService.class.isAssignableFrom(type)) {
			serviceName = "주문 갯수 관리 서비스";
		} else if (DeliveryService.class.isAssignableFrom(type)) {
			serviceName = "배달 리스트 관리 서비스";
		}
		
		return log.setServiceName(serviceName);
	}

}
