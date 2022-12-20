package org.zerock.service;

import org.zerock.domain.MemberVO;

public interface MemberService {
	
	int registerMember(MemberVO member);
	
	MemberVO getMember(String userid, String password);
	
	public MemberVO checkId(String userid);
	
	MemberVO idSearch(String password, String name, String email);
	
	MemberVO passwordSearch(String userid, String name, String email);
}
