package com.kfss.TaskManagementSystem;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="person")
public class user {
	@Id
	private long id;
	private String name;
	
}
