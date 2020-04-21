package com.ese.crud.member.controller;

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
import com.ese.crud.member.model.service.MemberService;
import com.ese.crud.member.model.vo.MemberVO;

@Controller
public class MemberController {
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="memberService")
	private MemberService memberService;
	
	@Resource(name="departmentService")
	private DepartmentService departmentService;
	
	@RequestMapping(value="member/memberList.do")
	public ModelAndView list(@RequestParam(defaultValue="1") int curPage) throws Exception{
		int listCnt = memberService.selectListCnt();
		Pagination pagination = new Pagination(listCnt, curPage);
		List<MemberVO> list = memberService.listAll(pagination);
				
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/memberList");
		mv.addObject("list", list);
		mv.addObject(pagination);

		return mv;
	}
	
	@RequestMapping(value="member/memberAdd.do")
	public ModelAndView addView() throws Exception {
		ModelAndView mv = new ModelAndView("member/memberAdd");
		
		mv.addObject("list", departmentService.listAll());
		
		return mv;
	}
	
	@RequestMapping(value="member/memberInsert.do")
	public @ResponseBody String insert(@ModelAttribute MemberVO vo) throws Exception{
		log.debug("intsert : " + vo.getMemberName() + " / " + vo.getDeptNo());
		
		String result = String.valueOf(memberService.insert(vo));
		log.debug("result : " + result);
		
		return result;
	}
	
	@RequestMapping(value="member/memberView.do")
	public ModelAndView modView(@RequestParam("member_no") int memberNo) throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", departmentService.listAll());
		mv.addObject("dto", memberService.selectOne(memberNo));
		mv.setViewName("member/memberView");
		
		return mv;
	}
	
	@RequestMapping(value="member/memberUpdate.do")
	public @ResponseBody String update(@ModelAttribute MemberVO vo) throws Exception{
		log.debug("update : " + vo.getMemberName() + " / " + vo.getDeptNo());
		
		String result = String.valueOf(memberService.update(vo));
		log.debug("result : " + result);
		
		return result;
	}
	
	@RequestMapping(value="member/memberDelete.do")
	public @ResponseBody String delete(@RequestParam("memberNo") int memberNo) throws Exception{
		log.debug("delete : " + memberNo);
		
		String result = String.valueOf(memberService.delete(memberNo));
		log.debug("result : " + result);
		
		return result;
	}
}
