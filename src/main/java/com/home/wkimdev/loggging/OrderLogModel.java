package com.home.wkimdev.loggging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class OrderLogModel {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderLogModel.class); 
	
	/* 서비스이름 */
	String serviceName;
	
	/* 요청시간 */
	String scheduleTime;
	
	/* 주문갯수 */
	String orderCount;
	
	/* 액션명 */
	String actionName;

	public void getOrderLogModel() {
		LOGGER.info("주문 로깅 모델 출력...| {} | {} | {} | {}", getActionName(), getScheduleTime(), 
				getOrderCount(), getServiceName());
	}
	
}
