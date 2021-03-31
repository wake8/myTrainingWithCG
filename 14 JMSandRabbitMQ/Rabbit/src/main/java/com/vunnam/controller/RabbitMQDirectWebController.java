package com.vunnam.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vunnam.model.Customer;

@RestController
@RequestMapping(value = "/rabbit/direct/")
public class RabbitMQDirectWebController {

	@Autowired
	private AmqpTemplate amqpTemplate;

	@PostMapping(value = "/producer")
	public String producer(@RequestParam("exchangeName") String exchange, @RequestParam("routingKey") String routingKey,
			@RequestBody Customer customer) {

		amqpTemplate.convertAndSend(exchange, routingKey, customer.toString());
		
		return "Customer object sent to the RabbitMQ Successfully";
	}

}
