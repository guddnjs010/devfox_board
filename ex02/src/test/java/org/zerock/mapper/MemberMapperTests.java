package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.MemberVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MemberMapperTests {

	
	@Setter(onMethod_ = @Autowired)
	private MemberMapper mapper;
	
	@Test
	public void insertMemberTest() {
		MemberVO member = new MemberVO();
		
		member.setUserid("user123");
		member.setPassword("password");
		member.setName("형원");
		member.setEmail("guddnjs@naver.com");
		
		mapper.insert(member);
		log.info("member: "+member);
		
	}
	
	@Test
	public void readMemberTest() {
		MemberVO member1 = new MemberVO();
		member1.setUserid("형원");
		member1.setPassword("1234");
		member1.setName("형원");
		member1.setEmail("sada@adasd.com");
		
		MemberVO member = mapper.readMember(member1.getUserid(), member1.getPassword());
		
		log.info("member정보 : " + member);
	}
}
