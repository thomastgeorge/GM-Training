package com.grayMatter.dto;

import org.springframework.stereotype.Component;

import com.grayMatter.entities.Items;

@Component
public class ItemsMapper {
	
	public ItemsDto mapToItemsDto(Items items) {
		return new ItemsDto(
				items.getIid(),
				items.getCpu()
				);
	}
	
	public Items mapToItems(ItemsDto itemsDto) {
		return new Items(
				itemsDto.getIid(),
				itemsDto.getCpu()
				);
	}

}
