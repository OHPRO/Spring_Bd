package org.zerock.persistence;

import org.zerock.domain.MemberVO;

//인터페이스는 만들때 오른쪽마우스 -> New -> 기타 -> interface를 하면 기본적인 것은 만들어짐. / Class로 생성 X
public interface MemberDAO {

	//< 메소드를 작성 : 밑에 구현한 메소드는 개발시 반드시 사용해서 개발/협업>
	//시간을 갖어오는 메소드를 구현
	
	public String getTime();
	
	public void insertMember(MemberVO vo);
	
	public MemberVO readMember(String userid) throws Exception;

	public MemberVO readWithPW(String userid, String userpw) throws Exception;
}
