package com.practise;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practise.Entity.Bill;
import com.practise.Entity.Patients;
import com.practise.Utility.HibernateUtility;

public class GetUpdateData {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Bill bill1 = new Bill();
		bill1.setBillType("Consultation");
		bill1.setBillingDate("2025-07-01");
		bill1.setAmount(800);
		
		Bill bill2 = new Bill();
		bill2.setBillType("Medication");
		bill2.setBillingDate("2025-07-03");
		bill2.setAmount(1200);
		
		List<Bill> billList = Arrays.asList(bill1,bill2);
		
		
		Patients patients = session.find(Patients.class, 5);
		patients.setName("Prerna Singh");
		patients.setAge(21);
		patients.setDisease("Viral Infection");
		patients.setAdmittedDate("2025-07-01");
		patients.setBill(billList);
		
		session.persist(patients);
		transaction.commit();
		session.close();
	}
}
