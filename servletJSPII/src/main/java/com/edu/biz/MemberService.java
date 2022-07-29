package com.edu.biz;

import com.edu.beans.Member;
import com.edu.dao.MemberDAO;

public class MemberService {

	private static MemberService service = new MemberService();

	private MemberService() {
	}

	public static MemberService getInstance() {
		return service;
	}

	MemberDAO dao = new MemberDAO();

	public void memberInsert(Member member) {
		dao.insertMember(member);
	}
}
