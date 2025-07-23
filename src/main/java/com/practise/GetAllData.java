package com.practise;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practise.Entity.Patients;
import com.practise.Utility.HibernateUtility;

public class GetAllData {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		List<Patients> patientList = session.createQuery("select p FROM Patients p", Patients.class).getResultList();

		patientList.stream().forEach(k -> System.out.println(k.toString()));

		transaction.commit();
		session.close();
	}
}
