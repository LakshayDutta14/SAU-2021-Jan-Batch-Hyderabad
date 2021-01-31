package com.accolite.demo.service;

import java.util.Map;

import com.accolite.demo.model.Item;

public interface OrderService {
	public String CreateOrder(Integer orderId);
	public String addItem(Integer orderId,Item item);


}
