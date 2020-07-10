package com.orderitemservice.model;

import java.util.List;
import java.util.Map;

import com.orderitemservice.model.OrderItemDetails;

public class OrderDetailsResponse {

		private Long status;
		public Long getStatus() {
			return status;
		}
		public void setStatus(Long status) {
			this.status = status;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		private String message;
		private int orderid;
		public int getOrderid() {
			return orderid;
		}
		public void setOrderid(int orderid) {
			this.orderid = orderid;
		}
		List<OrderItemDetails> orders;
		public List<OrderItemDetails> getOrders() {
			return orders;
		}
		public void setOrders(List<OrderItemDetails> orders) {
			this.orders = orders;
		}

}
