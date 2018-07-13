package org.zerock.web;

import javax.inject.Inject;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)  //스프링의 Runner를 참조한다
@ContextConfiguration (locations = {"classpath:spring/root-context.xml"})
public class MyBatisTest {

	@Inject
	private SqlSessionFactory sqlFactory;
	
	@Test
	public void testFactory() {
		System.out.println(sqlFactory);//sqlFactory를 잘가져오는지 찍어보자
	}
   
	@Test
	public void testSession() throws Exception {
		try {
			SqlSession session= sqlFactory.openSession();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
