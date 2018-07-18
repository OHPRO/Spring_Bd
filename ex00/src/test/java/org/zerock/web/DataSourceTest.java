package org.zerock.web;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)  //스프링의 Runner를 참조한다
@ContextConfiguration (locations = {"classpath:spring/root-context.xml"})
//src/main/webapp/WEB-INF/spring/root-context.xml 또는 web.xml에서 classpath로 설정후
//위에 처럼 classpath로 설정해줄수 있음.
//root-context에서 알트+엔터를 누르면 path경로가 나옴 그것을 붙이면됨

public class DataSourceTest {
	//DataSOurce indject "DI" 위에 있는 root-context를 데이터소스를 DI
	@Inject
	private DataSource ds;
	
	@Test //알트+시프트+t
	public void test() {
		try {
			Connection con = ds.getConnection();
		}
		catch(Exception e) {
			e.printStackTrace();
			
			//SQLException-데이터베이스 액세스 오류가 발생한 경우
		    // 자바 SQLSQLTimeout예외-드라이버가 setLoginTimeout메서드에서 지정한 시간 초과 값이 초과되어 현재 데이터베이스 연결 시도를 취소하려고 시도한 경우
		}
	}

}
