package com.zhwlt.logistics.netty.commons.http;

public interface HttpSession {
	public static final String SESSIONID = "MSESSIONID" ;
	public Object getAttribute(String name) ;
	public void setAttribute(String name,Object value) ;
	public void removeAttribute(String name) ;
	public String getId() ;
	public void invalidate() ;
}
