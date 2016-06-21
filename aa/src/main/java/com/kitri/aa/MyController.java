package com.kitri.aa;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	@Resource(name="memService")
	MemberDAO daoService;

	public void setDaoService(MemberDAO daoService) {
		this.daoService = daoService;
	}
	
	@RequestMapping(value= "/form.do")
	public String form(){
		return "form";
	}
	
	@RequestMapping(value= "/add.do")
	public String add(@ModelAttribute("xxx")Member m){
		daoService.insertMember(m);
		return "add_result";
	}
	
	@RequestMapping(value= "/list.do")
	public ModelAndView list(){
		ArrayList<Member> datas= daoService.getMembers();
		ModelAndView mav  = new ModelAndView("list");
		mav.addObject("datas", datas);
		return mav;
	}
	
	
}
