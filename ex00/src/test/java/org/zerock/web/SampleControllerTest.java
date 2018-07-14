package org.zerock.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)  //스프링의 Runner를 참조한다
@WebAppConfiguration
@ContextConfiguration (locations = {"classpath:spring/*.xml"}) //다른 파일과 다른점이 spring뒤에 /*라고 하면 모든 xml을 다봐라라는 뜻
public class SampleControllerTest {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleControllerTest.class); //클레스명은 바꿔주고
	
	@Autowired  //@Inject나 똑같다 근데 개인적으로 스프링에 있는 @Antowaired를 쓰겠다
	private WebApplicationContext ac;
	
	private MockMvc mockMvc;
	
	@Before //전처리 
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.ac).build();
		logger.info ("Before............."); 
				
	}

	@Test //실제 호출하는 녀석 //get방식으로 받겠다. //junit올라갈때  콘솔에 mapped가 있는지 확인해야함
	public void test() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/doC").param("msg", "SpringJUnit4Test")); 
		                 //꼭 get안에 "/"를 붙여야한다 안분이면 URL을 디스팬서 서블릿이 찾을수 없게 된다.
	}                    // 추가로 더 붙이려면 .param("  ", " ")를 하면된다

}
