package com.ese.crud.member.model.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ese.crud.Pagination;
import com.ese.crud.member.model.vo.MemberVO;

@Repository("memberDAO")
public class MemberDAO {
	Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<MemberVO> listAll(Pagination pagination) throws Exception{
		return sqlSession.selectList("member.listAll", pagination);
	}

	public int insert(MemberVO vo) throws Exception{
		return sqlSession.insert("member.insert", vo);
	}

	public MemberVO selectOne(int modelNo) throws Exception{
		return sqlSession.selectOne("member.selectOne", modelNo);
	}

	public int update(MemberVO vo) throws Exception{
		return sqlSession.update("member.update", vo);
	}

	public int delete(int modelNo) throws Exception{
		return sqlSession.delete("member.delete", modelNo);	
	}

	public int selectListCnt() throws Exception{
		return sqlSession.selectOne("member.selectListCnt");
	}
}
