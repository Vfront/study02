package spring.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.dto.FoodDTO;
import spring.mvc.module.FileWorks;
import spring.mvc.service.FoodService;

@org.springframework.stereotype.Controller
public class Controller {
	
	@Autowired
	private FoodService service;
	@Autowired
	private FileWorks fileWorks;
	
	@RequestMapping("insertForm.do")
	public String insertForm(){
		return "/WEB-INF/views/insertForm.jsp";
	}

	@RequestMapping(value="insert.do", method=RequestMethod.POST)
	public ModelAndView insertOne(FoodDTO dto, @RequestParam("upfile") MultipartFile upfile){
//		FoodDTO dto = new FoodDTO();
//		dto.setName(request.getParameter("name"));
		System.out.println(dto.getName());
		String sysname = fileWorks.uploadAndGetSysName(upfile);
		dto.setOrgname(upfile.getOriginalFilename());
		dto.setSysname(sysname);
		service.insertOne(dto);
		
		
		return new ModelAndView("redirect:selectList.do");
	}
	
	@RequestMapping("selectList")
	public ModelAndView selectList(){
		List<FoodDTO> list = service.selectList();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/views/selectList.jsp");
		mav.addObject("list", list);
		
		return mav;
		
	}
	@RequestMapping("selectOne")
	public ModelAndView selectOne(@RequestParam("num") int num){
		FoodDTO dto = service.selectOne(num);
		ModelAndView mav = new ModelAndView("WEB-INF/views/selectOne.jsp");
		mav.addObject("dto", dto);
		return mav;
	}
	
	@RequestMapping("updateForm.do")
	public ModelAndView updateForm(@RequestParam("num") int num){
		
		FoodDTO dto = service.selectOne(num);
		ModelAndView mav = new ModelAndView("WEB-INF/views/updateForm.jsp");
		mav.addObject("dto", dto);
		
		return mav;
		
	}
	@RequestMapping("updateOne.do")
	public String updateOne(FoodDTO dto, @RequestParam("upfile") MultipartFile upfile){
		String sysname = fileWorks.uploadAndGetSysName(upfile);
		dto.setOrgname(upfile.getOriginalFilename());
		dto.setSysname(sysname);
		
		service.updateOne(dto);
		return "redirect:selectList.do";
	}
	
	@RequestMapping("deleteOne.do")
	public String deleteOne(@RequestParam("num") int num){
		service.deleteOne(num);
		
		return "redirect:selectList.do";
	}
	@RequestMapping("updatePic.do")
	public void updatePic(){
//		System.out.println("zzz");
////		FoodDTO dto = service.selectOne(request.getParameter("sysname"));
//		service.deletePic(request.getParameter("sysname"));
//		
//		try {
//			PrintWriter out = response.getWriter();
//			out.println("gg");
//			out.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
	}
	@RequestMapping("imgUpdate.do")
	public ModelAndView imgModPage(@RequestParam("num") int num){
		FoodDTO dto = service.selectOne(num);
		ModelAndView mav = new ModelAndView();
		mav.addObject("dto" , dto);
		mav.setViewName("WEB-INF/views/imgUp.jsp");
		
		return mav;
	}
}
