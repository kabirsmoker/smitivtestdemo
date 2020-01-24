package com.xworkz.studentmanagement.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "student")
public class StudentDTO implements Serializable {

	private static final Logger logger = Logger.getLogger(StudentDTO.class);

	public StudentDTO() {
		logger.info("created Student Dto");
	}

	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	private int id;

	private String name;
	private int rollno;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	@Override
	public String toString() {
		return "StudentDTO [id=" + id + ", name=" + name + ", rollno=" + rollno + "]";
	}

}
