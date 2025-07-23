package com.practise.Entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "patients")
public class Patients {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private int age;
	
	private String disease;
	
	private String admittedDate;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "bill_id")
	private List<Bill> bill;
	

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

	
	public List<Bill> getBill() {
		return bill;
	}

	public void setBill(List<Bill> bill) {
		this.bill = bill;
	}

	@Override
	public String toString() {
		return "Patients [id=" + id + ", name=" + name + ", age=" + age + ", disease=" + disease + ", admittedDate="
				+ admittedDate + "]";
	}

	

	
	
	
}
