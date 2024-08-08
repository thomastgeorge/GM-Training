package com.grayMatter.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Component
public class Item {

	//@Value("${Item.itemId}")
	private int itemId;
	//@Value("${Item.itemName}")
	private String itemName;
	//@Value("${Item.cpu}")
	private int cpu;
}
