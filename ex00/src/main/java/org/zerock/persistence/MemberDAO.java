package org.zerock.persistence;

import org.zerock.domain.MemberVO;

//�������̽��� ���鶧 �����ʸ��콺 -> New -> ��Ÿ -> interface�� �ϸ� �⺻���� ���� �������. / Class�� ���� X
public interface MemberDAO {

	//< �޼ҵ带 �ۼ� : �ؿ� ������ �޼ҵ�� ���߽� �ݵ�� ����ؼ� ����/����>
	//�ð��� ������� �޼ҵ带 ����
	
	public String getTime();
	
	public void insertMember(MemberVO vo);
	
	public MemberVO readMember(String userid) throws Exception;

	public MemberVO readWithPW(String userid, String userpw) throws Exception;
}
