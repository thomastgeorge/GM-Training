package com.grayMatter.contoller;

import java.sql.Date;
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
public class CustomerController {

	@Autowired
	private CustomerService cservice;
	
	@Autowired
	private OrderService oservice;
	
	int cid=0;
	
	@RequestMapping("/cLogin")
	public String cLogin() {
		return "cLogin";
	}
	
	@RequestMapping("/cSignup")
	public String cSignup() {
		return "cSignup";
	}
	
	@RequestMapping("/cHome")
	public String cHome() {
	    return "cHome";
	}
	
	@RequestMapping("/cOrder")
	public String cOrder() {
		return "cOrder";
	}
	
	@RequestMapping("/cUpdateName")
	public String cUpdateName() {
		return "cUpdateName";
	}
	
	@RequestMapping("/cDeleteOrder")
	public String cDeleteOrder() {
		return "cDeleteOrder";
	}
	
	@RequestMapping("/cDeleteAccount")
	public String cDeleteAccount() {
		return "cDeleteAccount";
	}
	
	@RequestMapping("/cDoLogin")
	public ModelAndView cDoLogin(@RequestParam String cemail, @RequestParam String cpwd) {
		Customer c = cservice.getCustomerByEmail(cemail);
		ModelAndView mv=null;
		if(cpwd.equals(c.getCpwd())) {
			cid=c.getCid();
			mv = new ModelAndView("cHome");
			mv.addObject("cname", c.getCname());
		} else {
			mv = new ModelAndView("cLogin");
		}
		return mv;
	}
	
	@RequestMapping("/cDoSignup")
	public String cDoSignup(@RequestParam String cid, @RequestParam String cname, @RequestParam String cemail, @RequestParam String cpwd) {
		Customer c = new Customer(Integer.parseInt(cid), cname, cemail, cpwd);
		int count = cservice.addCustomer(c);
		if(count==1)
			return "cLogin";
		else
			return "cSignup";
	}
	
	@RequestMapping("/cDoOrder")
	public String cDoOrder(@RequestParam String oid, @RequestParam String tprice) {
		Date adate= new Date(System.currentTimeMillis());
		Order o = new Order(Integer.parseInt(oid), cid, Double.parseDouble(tprice), adate);
		int count = oservice.addOrder(o);
		if(count==1)	
			return"cHome";
		else
			return "cOrder";
	}
	
	@RequestMapping("/cViewOrder")
	public ModelAndView cViewOrder() {
		System.out.println(cid);
		List<Order> olist = oservice.getOrderByCId(cid);
		ModelAndView mv= new ModelAndView("cViewOrder");
		mv.addObject("list", olist);
		return mv;
	}
	
	@RequestMapping("/cDoDeleteOrder")
	public String cDoDeleteOrder(@RequestParam String oid) {
		int count = oservice.deleteOrderByOid(Integer.parseInt(oid));
		if(count>0) {
			return "cHome";
		}
		return "cDeleteOrder";
	}
	
	@RequestMapping("/cDoUpdateName")
	public String cDoUpdateName(@RequestParam String cname) {
		int count = cservice.updateCustomerName(cname, cid);
		if(count>0) {
			return "cHome";
		}
		return "cUpdateName";
	}

	@RequestMapping("/cDoDeleteAccount")
	public String cDoDeleteAccount(@RequestParam String cemail) {
		int counto = oservice.deleteOrderByCid(cid);
		int countc = cservice.deleteCustomer(cid);
		if(counto>0 && countc>0) {
			return "cLogin";
		}
		return "cDeleteAccount";
	}
}
