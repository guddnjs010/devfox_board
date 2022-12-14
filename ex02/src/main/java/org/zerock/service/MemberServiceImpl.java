package org.zerock.service;

import org.springframework.stereotype.Service;
import org.zerock.domain.MemberVO;
import org.zerock.mapper.BoardMapper;
import org.zerock.mapper.MemberMapper;
import org.zerock.mapper.ReplyMapper;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

@Service
@RequiredArgsConstructor
@Log4j
public class MemberServiceImpl implements MemberService{

	
	private final MemberMapper mapper;

	@Override
	public int registerMember(MemberVO member) {
		
		return mapper.insert(member);
	}

	@Override
	public MemberVO getMember(String userid, String password) {
		MemberVO member = new MemberVO();
		member = mapper.readMember(userid,password);
		
		return member;
	}

	@Override
	public MemberVO checkId(String userid) {
		// TODO Auto-generated method stub
		return mapper.checkId(userid);
	}

	@Override
	public MemberVO idSearch(String password, String name, String email) {
		MemberVO member = new MemberVO();
		member = mapper.idSearch(password, name, email);
		return member;
	}

	@Override
	public MemberVO passwordSearch(String userid, String name, String email) {
		MemberVO member = new MemberVO();
		member = mapper.passwordSearch(userid, name, email);
		return member;
	}
}
