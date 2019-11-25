package com.ankit.kafka.springbootkafkaexample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "User1")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "activity_id", unique = true, nullable = false)
	private int id;
	private String message;
	private String status;
   
}
