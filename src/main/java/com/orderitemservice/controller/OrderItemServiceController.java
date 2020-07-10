package com.orderitemservice.controller;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orderitemservice.model.OrderDetailsResponse;
import com.orderitemservice.model.OrderItemDetails;
import com.orderitemservice.service.OrderItemService;

@RestController
public class OrderItemServiceController 
{
	private static final Logger logger = LoggerFactory.getLogger(OrderItemServiceController.class);

	@Autowired
	OrderItemService orderItemService;
	/**
	 * Get API to retrieve all the orderitem details
	 * @return
	 */
	@GetMapping("/orderItemDetails")
	private List<OrderItemDetails> getAllOrder() 
	{
		return orderItemService.getAllOrder();
	}
	
	/**
	 * GET API to retrieve orderitem details for a single orderid
	 * @param id
	 * @return
	 */
	@GetMapping("/orderItemDetails/{id}")
	private List<OrderItemDetails> findByOrderid(@PathVariable("id") int id) 
	{
	return orderItemService.findByOrderid(id);
	}
	/*@GetMapping("/orderItemDetails/id/{id}")
	private OrderItemDetails getOrder(@PathVariable("id") int id) 
	{
		return orderItemService.getOrderById(id);
	}*/
	
	
	/**
	 * POST API to save data in orderitemdetails table
	 * @param order
	 * @return
	 */
	@PostMapping("/orderItemDetails")
	private ResponseEntity<Object> saveOrder(@RequestBody List<OrderItemDetails> order) 
	{
			OrderDetailsResponse response = new OrderDetailsResponse();
			try {
				if(order==null || order.size() ==0) {
					response.setMessage("FAILED : orderid can not be null");
					response.setStatus((long) 400);
				}
				else{
					orderItemService.saveOrUpdate(order);
					
					response.setMessage("SUCCESS");
					response.setStatus((long) 200);
					response.setOrderid(order.get(0).getOrderid());
				}
			return new ResponseEntity<Object>(response, HttpStatus.OK);
		}catch(Exception e) {
			logger.error("error occured while inserting record");
			response.setMessage("FAILED : error occured while inserting record");
			response.setStatus((long) 400);
			return new ResponseEntity<Object>(response, HttpStatus.OK);
		}
	}

}
