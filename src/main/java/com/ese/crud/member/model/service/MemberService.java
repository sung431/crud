package com.ese.crud.member.model.service;

import java.util.List;

import com.ese.crud.Pagination;
import com.ese.crud.member.model.vo.MemberVO;

public interface MemberService {
	
	public List<MemberVO> listAll(Pagination pagination) throws Exception;

	public int insert(MemberVO vo) throws Exception;

	public MemberVO selectOne(int modelNo) throws Exception;

	public int update(MemberVO vo) throws Exception;

	public int delete(int modelNo) throws Exception;

	public int selectListCnt() throws Exception;
	
}
