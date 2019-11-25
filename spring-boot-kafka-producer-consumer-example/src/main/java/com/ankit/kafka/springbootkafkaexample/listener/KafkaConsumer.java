package com.ankit.kafka.springbootkafkaexample.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.ankit.kafka.springbootkafkaexample.model.User;
import com.ankit.kafka.springbootkafkaexample.model.UserDao;

@Service
public class KafkaConsumer {
	@Autowired
	UserDao dao;

	/*
	 * @KafkaListener(topics = "hello", group = "group_id") public void
	 * consume(String message) {
	 * 
	 * System.out.println("Consumed message: " + message); }
	 */

	@KafkaListener(topics = "hello", group = "group_json", containerFactory = "userKafkaListenerFactory")
	public void consumeJson(User user) {
		user.setStatus("seen");
		dao.save(user);
		System.out.println("Consumed JSON Message: " + user);
	}

}