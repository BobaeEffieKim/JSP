package com.edu.customTag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class MyCustomTag extends TagSupport {

	private static final long serialVersionUID = 1L;

	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		System.out.println("끝태그를 만났습니다.");
		return super.doEndTag();
	}

	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		System.out.println("시작태그를 만났습니다.");
		return super.doStartTag();
	}

}
