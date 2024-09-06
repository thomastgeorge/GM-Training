package com.grayMatter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grayMatter.entities.Items;

public interface ItemsRepository extends JpaRepository<Items, Integer> {

}
