package com.practise.Repositories;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practise.Entity.Patients;

import com.practise.Utility.HibernateUtility;

public class PatientRepository {

	public void addData(Scanner sc) {
		Patients p = new Patients();
		sc.nextLine(); // to consume the leftover newline from previous nextInt()
		System.out.print("Enter Patient Name: ");
		String name = sc.nextLine();

		System.out.print("Enter Disease: ");
		String disease = sc.nextLine();

		System.out.print("Enter Admitted date: ");
		String date = sc.nextLine();
		
		System.out.print("Enter Patient Age: ");
		int age = sc.nextInt();


		sc.nextLine(); // again, consume newline

		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		p.setName(name);
		p.setAge(age);
		p.setDisease(disease);
		p.setAdmittedDate(date);

		session.persist(p);
		transaction.commit();
		session.close();

		System.out.println("Patient Details Added successfully ");
	}

	public void AllData(Scanner sc) {

		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		// We have to use parameterised query to filter
		List<Patients> plist = session.createQuery("select p from Patients p", Patients.class).getResultList();

		plist.stream().forEach(a -> System.out.println(a.toString()));

		transaction.commit();
		session.close();
	}

	public void updateData(Scanner sc) {
		System.out.println("Enter Id to update the disease or admitted data : ");
		int id = sc.nextInt();

		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Patients p = session.find(Patients.class, id);
		System.out.println("Enter New Disease or Admitted date :");
		String update = sc.next();

		p.setAdmittedDate(update);

		transaction.commit();
		session.close();
		System.out.println("Admitted date updated ");
	}

	public void deleteData(Scanner sc) {
		System.out.println("Enter the id of patient to  delete : ");
		int id = sc.nextInt();
		
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Patients p = session.find(Patients.class, id);
		session.remove(p);
		
		transaction.commit();
		session.close();
		
		System.out.println("Patient details deleted ");
	}

}
