package org.zerock.web;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)  //�������� Runner�� �����Ѵ�
@ContextConfiguration (locations = {"classpath:spring/root-context.xml"})
//src/main/webapp/WEB-INF/spring/root-context.xml �Ǵ� web.xml���� classpath�� ������
//���� ó�� classpath�� �������ټ� ����.
//root-context���� ��Ʈ+���͸� ������ path��ΰ� ���� �װ��� ���̸��

public class DataSourceTest {
	//DataSOurce indject "DI" ���� �ִ� root-context�� �����ͼҽ��� DI
	@Inject
	private DataSource ds;
	
	@Test //��Ʈ+����Ʈ+t
	public void test() {
		try {
			Connection con = ds.getConnection();
		}
		catch(Exception e) {
			e.printStackTrace();
			
			//SQLException-�����ͺ��̽� �׼��� ������ �߻��� ���
		    // �ڹ� SQLSQLTimeout����-����̹��� setLoginTimeout�޼��忡�� ������ �ð� �ʰ� ���� �ʰ��Ǿ� ���� �����ͺ��̽� ���� �õ��� ����Ϸ��� �õ��� ���
		}
	}

}
