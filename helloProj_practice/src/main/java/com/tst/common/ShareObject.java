package com.tst.common;

//정수형, 문자형으로 값 지정 -> 각각 서블릿으로 만들어서 공유하는 코드 만들기 
public class ShareObject {

	private int count;
	private String str;
	
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	
	
}
