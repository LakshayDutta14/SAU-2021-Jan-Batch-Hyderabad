package com.accolite.demo.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.accolite.demo.model.Item;
import com.accolite.demo.service.OrderService;



@ExtendWith(MockitoExtension.class)
class OrderControllerTest {

	@InjectMocks
    OrderController orderController;
    
    @Mock
    OrderService orderService;
    
	@Test
	void createOrderTest() {
		int id = 1;
        String result = "Order created Successfully Id : "+String.valueOf(id);
        Mockito.when(orderService.CreateOrder(id)).thenReturn(result);
        ResponseEntity<String> response = orderController.createOrder(id);
        Assertions.assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
        Assertions.assertEquals(200, response.getStatusCodeValue());
        Assertions.assertEquals(response.getBody(),result);
	}
	@Test
    void addItem(){
		int orderId = 1, itemId = 1;
        String result = "Item Added successfully orderId: "+orderId+"  itemId: "+itemId;
        Item item = new Item();
        item.setItemId(itemId); item.setItemName("phone"); item.setQuantity(12);
        Mockito.when(orderService.addItem(orderId, item)).thenReturn(result);
        ResponseEntity<String> response = orderController.addItem(orderId, item);
        Assertions.assertEquals(response.getBody(),result);
    }
	



}
