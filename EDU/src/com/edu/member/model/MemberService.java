package com.edu.member.model;

public class MemberService {
	// 처리하는 로직
	// 입력, 조회, 수정, 삭제 기능구현(실제 파일, DB X)
	MemberDAO dao = new MemberDAO();
	
	public void memberInsert(MemberVO member) {
		// 기능을 구현.
		dao.insertMember(member);
	}
}
