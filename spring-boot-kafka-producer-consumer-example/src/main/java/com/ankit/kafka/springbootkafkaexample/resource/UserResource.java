package com.ankit.kafka.springbootkafkaexample.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ankit.kafka.springbootkafkaexample.model.User;
import com.ankit.kafka.springbootkafkaexample.model.UserDao;


@RestController
@RequestMapping("kafka")
public class UserResource {

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;
    
    @Autowired
	private UserDao dao;

    private static final String TOPIC = "hello";
    
    @PostMapping("/publish")
    public String post(@RequestBody User user ) 
    {
    	user.setStatus("sent");
    	dao.save(user);
        kafkaTemplate.send(TOPIC, user);

        return "Message publiced"+"  "+user.toString();
    }
    @GetMapping("/getAll")
	public List<User> getAll() {
		return (List<User>) dao.findAll();
	}
    @DeleteMapping("/deleteAll")
	public String deleteAll() {
		dao.deleteAll();
		return "All record deleted!!!";
	}
}
