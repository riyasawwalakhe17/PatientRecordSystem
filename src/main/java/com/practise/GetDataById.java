package com.practise;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practise.Entity.Patients;
import com.practise.Utility.HibernateUtility;

public class GetDataById {

public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		int id = 1;
		Patients patients = session.find(Patients.class, 1);
		
		transaction.commit();
		session.close();
		System.out.println("DATA for Patient with id " + id + " : " + patients.toString());
	}
}
