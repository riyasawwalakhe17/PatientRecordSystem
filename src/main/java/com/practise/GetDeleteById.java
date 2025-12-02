package com.practise;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practise.Entity.Patients;
import com.practise.Utility.HibernateUtility;

public class GetDeleteById {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Patients patients = session.find(Patients.class, 2);
		session.remove(patients);

		System.out.println("Patient Data deleted successfully");
		transaction.commit();
		session.close();
	}
}
