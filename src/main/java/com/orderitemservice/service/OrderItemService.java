package com.orderitemservice.service;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderitemservice.exception.OrderNotFoundException;
import com.orderitemservice.model.OrderItemDetails;
import com.orderitemservice.repository.OrderItemRepository;
@Service
public class OrderItemService 
{
	@Autowired
	OrderItemRepository orderItemRepository;
	public List<OrderItemDetails> getAllOrder() 
	{
		List<OrderItemDetails> Orders = new ArrayList<OrderItemDetails>();
		orderItemRepository.findAll().forEach(Order -> Orders.add(Order));
		return Orders;
	}
	
	public List<OrderItemDetails> findByOrderid(int i) 
	{
		List<OrderItemDetails> Orders = new ArrayList<OrderItemDetails>();
		orderItemRepository.findByOrderid(i).forEach(Order -> Orders.add(Order));
		return Orders;
	}
	public OrderItemDetails getOrderById(int id) 
	{
		
		try {
			return orderItemRepository.findById(id).get();
		}catch(NoSuchElementException e) {
			throw new OrderNotFoundException();
		}
		
	}
	public void saveOrUpdate(List<OrderItemDetails> Order) 
	{
		orderItemRepository.saveAll(Order);
	}

}