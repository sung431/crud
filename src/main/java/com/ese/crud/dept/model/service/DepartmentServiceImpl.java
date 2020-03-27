package com.ese.crud.dept.model.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ese.crud.dept.model.dao.DepartmentDAO;
import com.ese.crud.dept.model.vo.DepartmentVO;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService{
	
	@Resource(name="departmentDAO")
	private DepartmentDAO departmentDAO;
	
	@Override
	public List<DepartmentVO> listAll() throws Exception {
		return departmentDAO.listAll();
	}

	@Override
	public int insert(DepartmentVO vo) throws Exception {
		return departmentDAO.insert(vo);
	}

	@Override
	public DepartmentVO selectOne(int deptNo) throws Exception {
		return departmentDAO.selectOne(deptNo);
	}

	@Override
	public int update(DepartmentVO vo) throws Exception {
		return departmentDAO.update(vo);
	}

	@Override
	public int delete(int deptNo) throws Exception {
		return departmentDAO.delete(deptNo);
	}

	@Override
	public int selectListCnt() throws Exception {
		return departmentDAO.selectListCnt();
	}

}
