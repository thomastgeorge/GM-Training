package com.grayMatter.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grayMatter.entities.Items;
import com.grayMatter.repository.ItemsRepository;

@Repository
public class ItemsDao {
	
	@Autowired
	private ItemsRepository itemsRepository;
	
	public Items getItemsById(int iid) {
		return itemsRepository.findById(iid).get();
	}
	
	public List<Items> getAllItems() {
		return itemsRepository.findAll();
	}
	
	public Items AddItems(Items items) {
		return itemsRepository.save(items);
	}

}
