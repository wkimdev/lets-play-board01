package com.home.wkimdev.loggging;

import com.home.wkimdev.OrderLogModel;

public class StandardLogUtils {
	
	// ThreadLocal를 사용하게 됨으로서, 변수의 유효범위가 특정 쓰레드 범위 내에서 유효해진다. 
	private static final ThreadLocal<OrderLogModel> LOG = new ThreadLocal<OrderLogModel>();
	
	/**
	 * 
	 */
	private StandardLogUtils() {
		// Do nothing.
	}
	
	/**
	 * 
	 * 현재 쓰레드의 로컬 변수값을 읽어온다. 
	 * @return
	 */
	public static OrderLogModel getLog() {

		return LOG.get();
	}

	/**
	 * 
	 * 현재 쓰레드의 로컬 변수에 값을 저장한다.  
	 * @param log
	 */
	public static void setLog(final OrderLogModel log) {

		LOG.set(log);
	}

	/**
	 * 
	 * 현재 쓰레드의 로컬 변수값을 삭제한다. 
	 */
	public static void removeLog() {

		LOG.remove();
	}
	
	
}
