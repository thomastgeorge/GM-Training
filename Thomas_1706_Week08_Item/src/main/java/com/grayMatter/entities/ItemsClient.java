package com.grayMatter.entities;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.grayMatter.dto.ItemsDto;
import com.grayMatter.dto.Orders;

@FeignClient(name="ORDERS-MICROSERVICE")
public interface ItemsClient {
	
	 @GetMapping("/api/v1/orders/items")
	    List<Orders> getOrdersByItemIds(@RequestParam("itemIds") List<Integer> itemIds);

	    @GetMapping("/api/v1/orders/{id}/items")
	    List<ItemsDto> getItemsByOrderId(@PathVariable("id") Integer orderId);
	
}
