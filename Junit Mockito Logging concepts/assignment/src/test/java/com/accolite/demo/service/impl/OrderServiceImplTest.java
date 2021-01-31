package com.accolite.demo.service.impl;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

//import com.accolite.auspringmvc.implement.add;
//import com.accolite.auspringmvc.implement.please;
import com.accolite.demo.model.Item;
import com.accolite.demo.model.Order;
import com.accolite.demo.service.OrderService;





class OrderServiceImplTest {
	Order order = new Order();
    Item item = new Item();
    OrderService orderService = new OrderServiceImpl();
	@Test
    void createOrder() {
        int id = 1;
        String res = orderService.CreateOrder(id);
        Assertions.assertEquals(res, "Order Created with order Id: "+id);
    }
	 @Test
     void addItem() {
         int orderId = 1; item.setItemId(1);
         item.setItemName("banana");
         item.setQuantity(5);
         String res1 = orderService.addItem(orderId, item);
         
         Assertions.assertEquals(res1, "No Order created, first create and then add items");

         String rest = orderService.CreateOrder(orderId);
         
         String res2 = orderService.addItem(orderId, item);
         Assertions.assertEquals(res2, "Item  successfully added with orderId  "+orderId+" and with itemId: "+item.getItemId());
     }

    

}
