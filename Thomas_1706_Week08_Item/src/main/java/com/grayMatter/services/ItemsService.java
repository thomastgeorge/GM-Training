package com.grayMatter.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.grayMatter.dao.ItemsDao;
import com.grayMatter.dto.ItemsDto;
import com.grayMatter.dto.ItemsMapper;
import com.grayMatter.dto.Orders;
import com.grayMatter.entities.ItemsClient;
import com.grayMatter.entities.Items;

@Service
public class ItemsService {
	
	@Autowired
	private ItemsDao itemsDao;
	
	@Autowired
	private ItemsMapper itemsMapper;
	
//	@Autowired
//	private ItemsClient itemsClient;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public List<ItemsDto> getAllItems(){
		List<Items> itemsList = itemsDao.getAllItems();
		return itemsList.stream()
				.map(itemsMapper::mapToItemsDto)
				.collect(Collectors.toList());
	}

	public ItemsDto getItemsById(int iid) {
		Items items = itemsDao.getItemsById(iid);
		return itemsMapper.mapToItemsDto(items);
	}
	
	public ItemsDto addItems(ItemsDto itemsDto) {
		return itemsMapper.mapToItemsDto(itemsDao.AddItems(itemsMapper.mapToItems(itemsDto)));
	}
	
	//Feign
//	 public List<Orders> getOrdersByItemIds(List<Integer> itemIds) {
//        return itemsClient.getOrdersByItemIds(itemIds);
//    }
	//RestTemplate
	public List<Orders> getOrdersByItemIds(List<Integer> itemIds) {
		return restTemplate.postForObject("http://ORDERS-MICROSERVICE/api/v1/orders/items", itemIds, List.class);
	}

	//Feign
    public List<ItemsDto> getItemsByOrderId(Integer orderId) {
    	 return restTemplate.getForObject("http://ORDERS-MICROSERVICE/api/v1/orders/" + orderId + "/items" , List.class);
    }
    //RestTemplate

}
