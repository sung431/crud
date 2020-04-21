package com.ese.crud.dept.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ese.crud.Pagination;
import com.ese.crud.dept.model.service.DepartmentService;
import com.ese.crud.dept.model.vo.DepartmentVO;

@Controller
public class DepartmentController {
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="departmentService")
	private DepartmentService departmentService;
	
	@RequestMapping(value="dept/deptList.do")
	public ModelAndView list(@RequestParam(defaultValue="1") int curPage) throws Exception{
		int listCnt = departmentService.selectListCnt();
		Pagination pagination = new Pagination(listCnt, curPage);
		List<DepartmentVO> list = departmentService.listAll();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("dept/deptList");
		mv.addObject("list", list);
		mv.addObject("pagination", pagination);
		
		return mv;
	}
	
	@RequestMapping(value="dept/deptAdd.do")
	public String addView() throws Exception {		
		return "dept/deptAdd";
	}
	
	@RequestMapping(value="dept/deptInsert.do")
	public @ResponseBody String insert(@ModelAttribute DepartmentVO vo) throws Exception{
		log.debug("insert : " + vo.getDeptName());
		
		String result = String.valueOf(departmentService.insert(vo));
		log.debug("result : " + result);
		
		return result;
	}
	
	@RequestMapping(value="dept/deptView")
	public ModelAndView modView(@RequestParam("dept_no") int deptNo) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("dto", departmentService.selectOne(deptNo));
		mv.setViewName("dept/deptView");
		
		return mv;
	}
	
	@RequestMapping(value="dept/deptUpdate.do")
	public @ResponseBody String update(@ModelAttribute DepartmentVO vo) throws Exception{
		log.debug("update : " + vo.getDeptName() + " / " + vo.getDeptNo());
		
		String result = String.valueOf(departmentService.update(vo));
		log.debug("result : " + result);
		
		return result;
	}
	
	@RequestMapping(value="dept/deptDelete.do")
	public @ResponseBody String delete(@RequestParam("deptNo") int deptNo) throws Exception{
		log.debug("delete : " + deptNo);
		
		String result = String.valueOf(departmentService.delete(deptNo));
		log.debug("result : " + result);
		
		return result;
	}
}
