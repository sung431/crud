package com.ese.crud.dept.model.service;

import java.util.List;

import com.ese.crud.dept.model.vo.DepartmentVO;

public interface DepartmentService {

	public List<DepartmentVO> listAll() throws Exception;

	public int insert(DepartmentVO vo) throws Exception;

	public DepartmentVO selectOne(int deptNo) throws Exception;

	public int update(DepartmentVO vo) throws Exception;

	public int delete(int deptNo) throws Exception;

	public int selectListCnt() throws Exception;

}
