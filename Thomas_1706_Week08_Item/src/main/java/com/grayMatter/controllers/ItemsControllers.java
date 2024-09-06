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

import com.grayMatter.dto.ItemsDto;
import com.grayMatter.dto.Orders;
import com.grayMatter.services.ItemsService;

@RestController
@RequestMapping("/api/v1/items")
public class ItemsControllers {

	@Autowired
	private ItemsService itemsService;
	
	@GetMapping()
	public List<ItemsDto> getAllCourse(){
		return itemsService.getAllItems();
	}
	
	@GetMapping("/{iid}")
	public ItemsDto getCourseById(@PathVariable("iid") int iid) {
		return itemsService.getItemsById(iid);
	}
	
	@PostMapping()
	public ItemsDto addItems(@RequestBody ItemsDto itemsDto) {
		return itemsService.addItems(itemsDto);
	}
	
	@GetMapping("/orders/items")
    public List<Orders> getOrdersByItemIds(@RequestParam List<Integer> itemIds) {
        return itemsService.getOrdersByItemIds(itemIds);
    }

    @GetMapping("/orders/{oid}")
    public List<ItemsDto> getItemsByOrderId(@PathVariable Integer oid) {
        return itemsService.getItemsByOrderId(oid);
    }
	
}
