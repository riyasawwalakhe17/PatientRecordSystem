package com.practise.Entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "patient_details")
public class Patients {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private int age;
	
	private String disease;
	
	private String admittedDate;

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public String getAdmittedDate() {
		return admittedDate;
	}

	public void setAdmittedDate(String admittedDate) {
		this.admittedDate = admittedDate;
	}

	@Override
	public String toString() {
		return "Patients [id=" + id + ", name=" + name + ", age=" + age + ", disease=" + disease + ", admittedDate="
				+ admittedDate + "]";
	}

	
	
}
