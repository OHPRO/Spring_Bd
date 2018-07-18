package org.zerock.web;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.MemberVO;
import org.zerock.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)  //스프링의 Runner를 참조한다
@ContextConfiguration (locations = {"classpath:spring/root-context.xml"})

public class MemberDAOTest {
	
	@Autowired
	private MemberDAO dao;
	
	@Test
	public void testTime() {
		System.out.println(dao.getTime());
	}
	
	@Test
	public void testInsertMember() throws Exception {
		MemberVO vo = new MemberVO("user00","user00","USER00","user00@aaa.com");
		
		dao.insertMember(vo);
	}
	
}