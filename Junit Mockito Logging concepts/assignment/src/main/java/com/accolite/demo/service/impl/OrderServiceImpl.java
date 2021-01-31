package com.accolite.demo.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.accolite.demo.model.Item;
import com.accolite.demo.model.Order;
import com.accolite.demo.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	Map<Integer,Order> mp=new HashMap<Integer,Order>();
	
	
	public boolean isOrderPresent(Integer orderId) {
		if(mp.containsKey(orderId))
			return true;
		return false;
	}
	@Override
	public String CreateOrder(Integer orderId) {
		Order o=new Order();
		o.setOrderId(orderId);
		mp.put(orderId, o);
		return "Order Created with order Id: "+o.getOrderId();
		
	}

	@Override
	public String addItem(Integer orderId, Item item) {
		if(isOrderPresent(orderId))
		{
			
			mp.get(orderId).getitems().put(item.getItemId(), item);
			System.out.println(mp.get(orderId));
			return "Item  successfully added with orderId  "+orderId+" and with itemId: "+item.getItemId();
		}
		return "No Order created, first create and then add items";
	}

}
