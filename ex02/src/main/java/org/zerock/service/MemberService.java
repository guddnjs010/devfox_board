package org.zerock.service;

import org.zerock.domain.MemberVO;

public interface MemberService {
	
	int registerMember(MemberVO member);
	
	MemberVO getMember(String userid, String password);
}
