package com.home.wkimdev.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.home.wkimdev.service.DeliveryService;
import com.home.wkimdev.service.OrderService;

/*
 * 주문 모니터링 
 */
@Service
public class OrderTaskService {
		
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderTaskService.class);
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	DeliveryService deliveryService;
	
	@Scheduled(cron="0/5 * * * * ?")
    public void TeskOrderScheduler(){
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd-hhmmss");
		orderService.getOrderCount();
//		 LOGGER.info(" [ 주문 | 요청 | 스케줄링 테스트 : 실행시간 {} ]", dateFormat.format(date));
	}
	
	@Scheduled(cron="0/30 * * * * ?")
    public void TeskDeliveryScheduler(){
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd-hhmmss");
		deliveryService.getDeliveryList();
//		LOGGER.info(" [ 주문 | 출고 | 스케줄링 테스트 : 실행시간 {} ]", dateFormat.format(date));
    }
}
