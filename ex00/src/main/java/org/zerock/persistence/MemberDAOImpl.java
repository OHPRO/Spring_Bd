package org.zerock.persistence;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zerock.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {


	@Autowired
	private SqlSession sqlSession;
	private Map<String, String> paramMap;
	
	//MemberDAO의 인터페이스를 갖여와서 오버라이드(재정의) 
	//오버라이드의 안에 있는 () 함수는 memberMaper에 경로다. 쿼리문
	@Override
	public String getTime() {
		return sqlSession.selectOne("member.getTime");
	}

	@Override
	public void insertMember(MemberVO vo) {
		sqlSession.insert("member.insertMember", vo);
		
	}

	@Override
	public MemberVO readMember(String userid) throws Exception {
		MemberVO vo= sqlSession.selectOne("member.selectMember",userid);
		return vo;
	}

	@Override
	public MemberVO readWithPW(String userid, String userpw) throws Exception {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("userid", userid);
		paramMap.put("userpw", userpw);
		
		return sqlSession.selectOne("member.readWithPW", paramMap);
	}


}
