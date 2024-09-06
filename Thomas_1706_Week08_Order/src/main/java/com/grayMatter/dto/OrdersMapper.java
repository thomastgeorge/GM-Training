package com.grayMatter.dto;

import org.springframework.stereotype.Component;

import com.grayMatter.entities.Orders;

@Component
public class OrdersMapper {
	
	public OrdersDto mapToOrdersDto(Orders orders) {
		return new OrdersDto(
				orders.getOid(),
				orders.getDate(),
				orders.getTotalCost(),
				orders.getItemsIds()
				);
	}
	
	public Orders mapToOrders(OrdersDto ordersDto) {
		return new Orders(
				ordersDto.getOid(),
				ordersDto.getDate(),
				ordersDto.getTotalCost(),
				ordersDto.getItemsIds()
				);
	}

}
