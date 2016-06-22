package com.kitri.aa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

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
	//페이지 이동
	@RequestMapping(value= "/loginform.do")
	public String loginform(){
		return "/join/loginForm";
	}
	//페이지 이동
	@RequestMapping(value= "/joinform.do")
	public ModelAndView joinform(){
		ModelAndView mav = new ModelAndView("/join/joinForm");
		ArrayList<Member> m = daoService.getMembers();
		int maxnum = 0;
		for (int i = 0; i < m.size(); i++) {
			String p = m.get(i).toString(); 
			int endIndex = p.indexOf(",");
			String j = p.substring(8, endIndex);
			String[] result0= j.split("=");
			int[] result = new int[result0.length];	
			for (int k = 0; k < result0.length; k++) {
				String cp = result0[k];				
				if (!cp.equals("num")) {
					result[k] =	Integer.parseInt(cp);
				}
				int max = result[0];
				int min = result[0];
				for(int g=1; g < result.length ; g++) {
					if( result[g] > max )
						max = result[g];
					if (result[g] < min )
						min = result[g];
				}
			}
			maxnum = result[result.length - 1];
		}
		//System.out.println(maxnum);
		return mav;
	} 

	@RequestMapping(value= "/join/login.do")
	public String login(Member m,HttpSession session){
		Member mb = daoService.getMember(m.getNum());
		if(m.getName().equals(mb.getName())){
			System.out.println("로그인성공");
			session.setAttribute("num", mb.getNum());
			return "/join/main";			
		}else{
			return "/join/loginForm";
		}
	}

	@RequestMapping(value= "/join/join.do")
	public String join(Member m){
		daoService.insertMember(m);
		return "/join/loginForm";
	}


}
