package com.grayMatter.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.grayMatter.model.Customer;
import com.grayMatter.model.Order;
import com.grayMatter.service.CustomerService;
import com.grayMatter.service.OrderService;

@Controller
public class AdminController {
	
	@Autowired
	private CustomerService cservice;
	
	@Autowired
	private OrderService oservice;
	
	@RequestMapping("/aLogin")
	public String aLogin() {
		return "aLogin";
	}
	
	@RequestMapping("/aHome")
	public String aHome() {
	    return "aHome";
	}
	
	@RequestMapping("/aDeleteOrder")
	public String aDeleteOrder() {
		return "aDeleteOrder";
	}
	
	@RequestMapping("/aDeleteAccount")
	public String aDeleteAccount() {
		return "aDeleteAccount";
	}
	
	@RequestMapping("/aViewOrderById")
	public String aViewOrderById() {
		return "aViewOrderById";
	}
	
	@RequestMapping("/aDoLogin")
	public String aDoLogin(@RequestParam String aemail, @RequestParam String apwd) {
		if(apwd.equals("Admin@123") && aemail.equals("admin@gmail.com")) {
			return"aHome";
		} else {
			return"aLogin";
		}
	}
	
	@RequestMapping("/aViewAllCustomers")
	public ModelAndView aViewAllCustomers() {
		List<Customer> clist = cservice.getAllCustomer();
		ModelAndView mv= new ModelAndView("aViewCustomers");
		mv.addObject("list", clist);
		return mv;
	}
	
	@RequestMapping("/aViewAllOrders")
	public ModelAndView aViewAllOrders() {
		List<Order> olist = oservice.getAllOrder();
		ModelAndView mv= new ModelAndView("aViewOrders");
		mv.addObject("list", olist);
		return mv;
	}
	

	@RequestMapping("/aDoDeleteOrder")
	public String aDoDeleteOrder(@RequestParam String oid) {
		int count = oservice.deleteOrderByOid(Integer.parseInt(oid));
		if(count>0) {
			return "aHome";
		}
		return "aDeleteOrder";
	}
	
	@RequestMapping("/aDoDeleteAccount")
	public String aDoDeleteAccount(@RequestParam String cid) {
		int counto = oservice.deleteOrderByCid(Integer.parseInt(cid));
		int countc = cservice.deleteCustomer(Integer.parseInt(cid));
		if(counto>0 && countc>0) {
			return "aHome";
		}
		return "aDeleteAccount";
	}
	
	@RequestMapping("/aViewById")
	public ModelAndView aViewById(@RequestParam String cid) {
		List<Order> olist = oservice.getOrderByCId(Integer.parseInt(cid));
		ModelAndView mv= new ModelAndView("aViewOrders");
		mv.addObject("list", olist);
		return mv;
	}
	
	
}
