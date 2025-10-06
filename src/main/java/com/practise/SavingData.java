package com.practise;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practise.Entity.Bill;
import com.practise.Entity.Patients;
import com.practise.Utility.HibernateUtility;

public class SavingData {

	public static void main(String[] args) {

		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Bill bill1 = new Bill();
		bill1.setBillType("Room Charges");
		bill1.setBillingDate("2025-07-02");
		bill1.setAmount(4500);
		
		Bill bill2 = new Bill();
		bill2.setBillType("Lab Tests");
		bill2.setBillingDate("2025-07-03");
		bill2.setAmount(1200);
		
		Bill bill3 = new Bill();
		bill3.setBillType("Medicines");
		bill3.setBillingDate("2025-07-04");
		bill3.setAmount(2300);

		List<Bill> billList = Arrays.asList(bill1,bill2,bill3);
		
		Patients patient = new Patients();
		patient.setName("Rohan Joshi");
		patient.setAge(35);
		patient.setDisease("Dengue");
		patient.setAdmittedDate("2025-07-01");
		patient.setBill(billList);

		System.out.println("Data saved sucessfully");
		session.persist(patient);
		transaction.commit();
		session.close();

	}
}
