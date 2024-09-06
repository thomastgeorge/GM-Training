package com.grayMatter.entities;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.grayMatter.dto.Items;

@FeignClient(name="ITEMS-MICROSERVICE")
public interface OrdersClient {
	
	@GetMapping("/api/v1/items/{iid}")
	public Items getItem(@PathVariable("iid") Integer id);
	
}

