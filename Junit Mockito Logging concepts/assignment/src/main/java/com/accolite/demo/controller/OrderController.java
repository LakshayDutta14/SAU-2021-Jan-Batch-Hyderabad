package com.accolite.demo.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.accolite.demo.model.Item;
import com.accolite.demo.service.OrderService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/order/")
public class OrderController {
	
	@Autowired
	OrderService service;
	
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	@PostMapping("/create/{orderid}")
	public ResponseEntity<String> createOrder(@PathVariable("orderid") Integer orderId)
	{
		String res=service.CreateOrder(orderId);
		logger.info("order created success "+orderId+" : "+orderId);
		return ResponseEntity.ok(res);
	}
	@PostMapping("/item/add/{orderid}")
	public ResponseEntity<String> addItem(@PathVariable("orderid") Integer orderId,@RequestBody Item item)
	{
		String res=service.addItem(orderId, item);
		return ResponseEntity.ok(res);
	}

}
