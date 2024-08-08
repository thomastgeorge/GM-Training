package com.grayMatter.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.grayMatter.model.Student;

@Controller
public class StudentController {
	
	static List<Student> ls = new ArrayList<>();
	
	StudentController() {
		Student s= new Student(1, "User");
		ls.add(s);
	}
	
	@RequestMapping("/home")
	public String home() {
	    return "home";
	}

	@RequestMapping("/add")
	public String add() {
		return "add";
	}

	@RequestMapping("/delete")
	public String delete() {
		return "delete";
	}
	
	@RequestMapping("/update")
	public String update() {
		return "update";
	}
	
	@RequestMapping("/login")	//this should matches with the jsp action
	public ModelAndView login(@RequestParam String name, @RequestParam String pwd) {
		ModelAndView mv=null;
		if(name.equals("User") && pwd.equals("12345")) {
			mv=new ModelAndView("home");
			mv.addObject("name", name);
		} else
			mv=new ModelAndView("login");
		return mv;
	}
	
	@RequestMapping(value="/add/addStudent", method=RequestMethod.POST)
	public String addStudent(@RequestParam String id, @RequestParam String name) {
		Student st = new Student(Integer.parseInt(id), name);
		ls.add(st);
		return "redirect:/home";
	}

	@RequestMapping(value = {"/viewAll"}, method = RequestMethod.GET)
	public ModelAndView viewAll() {
		ModelAndView mv=new ModelAndView("view");
		mv.addObject("list", ls);
		mv.addObject("action", "All");
		return mv;
	}
	
	@RequestMapping("/deleteStudent")
	public ModelAndView deleteStudent(@RequestParam String id) {
		int id1=Integer.parseInt(id);
		Iterator<Student> iterator = ls.iterator();
		while (iterator.hasNext()) {
			Student student = iterator.next();
			if (student.getId() == id1) {
				iterator.remove();
				break;
			}
		}
		return new ModelAndView("home");
	}
	
	@RequestMapping("/updateStudent")
	public ModelAndView updateStudent(@RequestParam String name,@RequestParam String id) {
		int id1=Integer.parseInt(id);
		for (Student s : ls) {
			if(s.getId()==id1){
				s.setName(name);
				break;
			}	
		}
		ModelAndView mv=new ModelAndView("home");
		return mv;
	}
	
}
