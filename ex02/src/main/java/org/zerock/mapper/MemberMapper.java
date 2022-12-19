package org.zerock.mapper;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.MemberVO;

public interface MemberMapper {

	int insert(MemberVO member);
	
	MemberVO readMember(@Param("userid") String userid, @Param("password") String password);
	
	public MemberVO checkId(String userid);
	
	
}
