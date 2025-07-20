package com.practise;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.practise.Repositories.PatientRepository;
import com.practise.Utility.HibernateUtility;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("WELCOME TO PATIENT RECORD SYSTEM");
			System.out.println("Please Select as per Requirement");
			System.out.println("1. Add new patient");
			System.out.println("2. View All records");
			System.out.println("3. Update disease or admitted date");
			System.out.println("4. Delete patient by ID");

			System.out.println("Please Enter your choice: ");
			int choice = sc.nextInt();

			PatientRepository patient = new PatientRepository();
			switch (choice) {
			case 1:
				patient.addData(sc);
				break;

			case 2:

				patient.AllData(sc);
				break;

			case 3:
				patient.updateData(sc);
				break;

			case 4:
				patient.deleteData(sc);
				break;
			}

		}
	}
}
