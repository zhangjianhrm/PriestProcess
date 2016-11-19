package com.lenovo.lps.farseer.priest2.platform.util;

import java.util.concurrent.Semaphore;

/**
 * <pre>
 * JbpmProcessServiceImpl.java类	
 * kbuilder.add(new ByteArrayResource(bpmnDef.getBytes("utf-8")), ResourceType.BPMN2);有线程安全问题 
 * 触发时会报Process has no begin/end node．
 * 本类为该问题workaroud，调用kbuilder.add()前须获取锁
 * </pre>
 * 
 * @author niexm1
 * 
 */
public final class JbpmCallLock {
	
	private JbpmCallLock() {
	}

	static final Semaphore jbpmAddlock = new Semaphore(1);

	/**
	 * 获取锁，以调用KnowledgeBuilder.add()方法
	 * 
	 * @throws InterruptedException
	 */
	public static void getKnowledgeBuilderAddLock() throws InterruptedException {
		jbpmAddlock.acquire();
	}

	/**
	 * 释放锁，以备其它线程调用KnowledgeBuilder.add()方法
	 */
	public static void releaseKnowledgeBuilderAddLock() {
		jbpmAddlock.release();
	}
}
