package com.orderitemservice.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.orderitemservice.model.OrderItemDetails;
public interface OrderItemRepository extends CrudRepository<OrderItemDetails, Integer>
{
	List<OrderItemDetails> findByOrderid(int i);
}
