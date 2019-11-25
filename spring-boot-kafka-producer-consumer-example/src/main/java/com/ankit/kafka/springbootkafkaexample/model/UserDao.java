package com.ankit.kafka.springbootkafkaexample.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends JpaRepository<User, Integer> {

}
