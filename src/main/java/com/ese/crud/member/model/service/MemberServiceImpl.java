package com.ese.crud.member.model.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ese.crud.member.model.vo.MemberVO;
import com.ese.crud.Pagination;
import com.ese.crud.member.model.dao.MemberDAO;
import com.ese.crud.member.model.service.MemberService;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	@Resource(name="memberDAO")
	private MemberDAO memberDAO;
	
	@Override
	public List<MemberVO> listAll(Pagination pagination) throws Exception {
		return memberDAO.listAll(pagination);
	}

	@Override
	public int insert(MemberVO vo) throws Exception {
		return memberDAO.insert(vo);
	}

	@Override
	public MemberVO selectOne(int modelNo) throws Exception{
		return memberDAO.selectOne(modelNo);
	}

	@Override
	public int update(MemberVO vo) throws Exception {
		return memberDAO.update(vo);
	}

	@Override
	public int delete(int modelNo) throws Exception {
		return memberDAO.delete(modelNo);
	}

	@Override
	public int selectListCnt() throws Exception {
		return memberDAO.selectListCnt();
	}
	
}
