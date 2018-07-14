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

@RunWith(SpringJUnit4ClassRunner.class)  //�������� Runner�� �����Ѵ�
@WebAppConfiguration
@ContextConfiguration (locations = {"classpath:spring/*.xml"}) //�ٸ� ���ϰ� �ٸ����� spring�ڿ� /*��� �ϸ� ��� xml�� �ٺ����� ��
public class SampleControllerTest {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleControllerTest.class); //Ŭ�������� �ٲ��ְ�
	
	@Autowired  //@Inject�� �Ȱ��� �ٵ� ���������� �������� �ִ� @Antowaired�� ���ڴ�
	private WebApplicationContext ac;
	
	private MockMvc mockMvc;
	
	@Before //��ó�� 
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.ac).build();
		logger.info ("Before............."); 
				
	}

	@Test //���� ȣ���ϴ� �༮ //get������� �ްڴ�. //junit�ö󰥶�  �ֿܼ� mapped�� �ִ��� Ȯ���ؾ���
	public void test() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/doC").param("msg", "SpringJUnit4Test")); 
		                 //�� get�ȿ� "/"�� �ٿ����Ѵ� �Ⱥ��̸� URL�� ���Ҽ� ������ ã���� ���� �ȴ�.
	}                    // �߰��� �� ���̷��� .param("  ", " ")�� �ϸ�ȴ�

}
