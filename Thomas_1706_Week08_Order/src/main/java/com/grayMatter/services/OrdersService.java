package com.grayMatter.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.grayMatter.dao.OrdersDao;
import com.grayMatter.dto.Items;
import com.grayMatter.dto.OrdersDto;
import com.grayMatter.dto.OrdersMapper;
import com.grayMatter.entities.Orders;
import java.util.StringJoiner;
import com.grayMatter.entities.OrdersClient;

@Service
public class OrdersService {
	
	@Autowired
	private OrdersDao ordersDao;
	
	@Autowired
	private OrdersMapper ordersMapper;
	
//	@Autowired
//	private OrdersClient ordersClient;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public OrdersDto getOrdersById(int oid) {
		Orders orders = ordersDao.getOrdersById(oid);
		return ordersMapper.mapToOrdersDto(orders);
	}
	
	//Feign
//	public List<Items> getItemsByOrderId(int orderId) {
//        Orders order = ordersDao.getOrdersById(orderId);
//        if (order == null) return List.of();
//        return (List<Items>) order.getItemsIds().stream()
//            .map(itemId -> ordersClient.getItem(itemId))
//            .collect(Collectors.toList());
//    }
	//RestTemplate
	public List<Items> getItemsByOrderId(int orderId) {
      Orders order = ordersDao.getOrdersById(orderId);
      if (order == null) return List.of();
      List<Integer> itemIds = order.getItemsIds();
      List<Items> items = itemIds.stream()
              .map(itemId -> restTemplate.getForObject("http://ITEMS-MICROSERVICE/api/v1/items/" + itemId, Items.class))
              .collect(Collectors.toList());

      return items;
  }
	
	
	
	//Feign
//	public List<OrdersDto> getOrdersByItemIds(List<Integer> itemIds){
//		 List<Orders> orders = ordersDao.getOrdersByItemIds(itemIds);
//	        return orders.stream()
//	            .map(ordersMapper::mapToOrdersDto)
//	            .collect(Collectors.toList());
//	}
//	RestTemplate
	public List<OrdersDto> getOrdersByItemIds(List<Integer> itemIds){
		//return restTemplate.postForObject("http://ITEMS-MICROSERVICE/api/v1/items/orders/items?itemIds=", itemIds, List.class);
		StringBuilder sb = new StringBuilder();
        for (int i = 0; i < itemIds.size(); i++) {
            if (i > 0) {
                sb.append(",");
            }
            sb.append(itemIds.get(i));
        }
        String itemIdsParam = sb.toString();


        // Make the POST request and return the response
        return restTemplate.postForObject("http://ITEMS-MICROSERVICE/api/v1/items/orders/items?itemIds=" + itemIdsParam, null, List.class);
	}

	public List<OrdersDto> getAllOrders() {
		List<Orders> ordersList = ordersDao.getAllOrders();
		return ordersList.stream()
				.map(ordersMapper::mapToOrdersDto)
				.collect(Collectors.toList());
	}
	
	public OrdersDto addOrders(OrdersDto ordersDto) {
		ordersDto.setDate(new Date(System.currentTimeMillis()));
		return ordersMapper.mapToOrdersDto(ordersDao.addOrders(ordersMapper.mapToOrders(ordersDto)));
	}

}
