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
		System.out.println("1111");
		MemberVO member = new MemberVO();
		member = mapper.readMember("형원","1234");
		
		log.info("member정보 : " + member);
	}
	
	@Test
	public void idSearchTest() {
		String password = "1234";
		String name = "김형원";
		String email ="guddnjs@navd.com";
		
		MemberVO member = mapper.idSearch(password, name, email);
		
		log.info(member);
		
		
	}
	
	@Test
	public void passwordSearchTest() {
		String userid ="user";
		String name = "형원";
		String email ="guddnjs@navercom";
		MemberVO member = mapper.passwordSearch(userid, name, email);
		
		log.info(member);
		
	}
}
