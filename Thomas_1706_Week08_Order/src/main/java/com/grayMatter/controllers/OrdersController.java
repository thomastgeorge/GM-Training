package com.grayMatter.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grayMatter.dto.Items;
import com.grayMatter.dto.OrdersDto;
import com.grayMatter.services.OrdersService;

@RestController
@RequestMapping("/api/v1/orders")
public class OrdersController {

	@Autowired
	private OrdersService ordersService;
	
	@GetMapping("/{oid}")
	public OrdersDto getOrdersById(@PathVariable("oid") int oid) {
		return ordersService.getOrdersById(oid);
	}
	
	@GetMapping()
	public List<OrdersDto> getAllOrders() {
		return ordersService.getAllOrders();
	}
	
	@PostMapping()
	public OrdersDto addOrders(@RequestBody OrdersDto ordersDto) {
		return ordersService.addOrders(ordersDto);
	}
	
	@GetMapping("/{oid}/items")
	public List<Items> getItemsByOrderId(@PathVariable int oid){
		return ordersService.getItemsByOrderId(oid);
	}
	
	@GetMapping("/items")
	public List<OrdersDto> getOrdersByItemsIds(@RequestParam List<Integer> itemsIds){
		return ordersService.getOrdersByItemIds(itemsIds);
	}
	
}
