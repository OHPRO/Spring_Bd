package org.zerock.persistence;

import org.apache.ibatis.session.SqlSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zerock.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {


	@Autowired
	private SqlSession sqlSession;
	
	//MemberDAO�� �������̽��� �����ͼ� �������̵�(������)
	@Override
	public String getTime() {
		return sqlSession.selectOne("member.getTime");
	}

	@Override
	public void insertMember(MemberVO vo) {
		sqlSession.insert("member.insertMember", vo);
		
	}

	@Override
	public MemberVO readmember(String userid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO readwithPW(String userid, String userpw) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
