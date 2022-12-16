package org.zerock.mapper;

import org.zerock.domain.MemberVO;

public interface MemberMapper {

	int insert(MemberVO member);
	
	MemberVO readMember(String userid, String password);
}
