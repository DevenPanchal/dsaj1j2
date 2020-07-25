package com.neha.learning;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class TestingPharmacy {

	static SimpleDateFormat ft = new SimpleDateFormat("EEE, h:mm a");

	ArrayList<Pharmacy> listOfPharmacies = new ArrayList<Pharmacy>();

	public static void main(String[] args) {

		// As a user, I want to register, login

		User u = new User();
		u.register("Neha", Role.USER, "nrp@gmail.com", "bangalibabakijay");
		System.out.println("You are registered as " + u.toString());

		// As a Data Entry Operator or Store Manager, I want to register, login

		TestingPharmacy t = new TestingPharmacy();
		t.transact(u);
	}

	public void transact(User u) {

		// Depending upon the User object please perform required authorizations. Not
		// implemented here to due to
		// severe and constant pressure from Swati.

		// Post medicine availabilities, update Pharmacy

		// Creating 2 Pharmacy Objects to tests

		Medicine m1 = new Medicine("Metacin", 3, 115.0f);
		Medicine m2 = new Medicine("Crocin", 9, 315.0f);
		Medicine m3 = new Medicine("Avil", 5, 1144.0f);
		Medicine m4 = new Medicine("Vicks", 6, 5.0f);
		Medicine m5 = new Medicine("Digene", 77, 1.0f);
		Medicine m6 = new Medicine("Sodamint", 19, 11.0f);

		ArrayList<Medicine> listofMedsAtP1 = new ArrayList<Medicine>();
		listofMedsAtP1.add(m1);
		listofMedsAtP1.add(m2);
		listofMedsAtP1.add(m3);

		// Time will be using the console, so no need to add it in the constructor.
		// Once the timing is set for this Pharmacy, the timings object will be updated.

		Pharmacy p1 = new Pharmacy("Mumbai", "Mamta", listofMedsAtP1);

		// ------//

		ArrayList<Medicine> listofMedsAtP2 = new ArrayList<Medicine>();
		listofMedsAtP2.add(m4);
		listofMedsAtP2.add(m5);
		listofMedsAtP2.add(m6);
		listofMedsAtP2.add(m1);

		Pharmacy p2 = new Pharmacy("Kandivali", "Dev Medical", listofMedsAtP2);

		// ------//

		ArrayList<Medicine> listofMedsAtP3 = new ArrayList<Medicine>();
		listofMedsAtP3.add(m1);
		listofMedsAtP3.add(m5);
		listofMedsAtP3.add(m6);
		listofMedsAtP3.add(m4);

		Pharmacy p3 = new Pharmacy("Ghatkopar", "Sarvodaya", listofMedsAtP3);

		listOfPharmacies.add(p1);
		listOfPharmacies.add(p2);
		listOfPharmacies.add(p3);

		System.out.println("Enter the Medicine you want");
		Scanner s = new Scanner(System.in);
		String mNameFromInput = s.nextLine();

		Medicine medicine = new Medicine();
		medicine.setMedicineName(mNameFromInput);
		searchMedicine(medicine);

		// Buy

	}

// Search, View
	int counter = 0;

	public void searchMedicine(Medicine medToSearch) {

		System.out.println("Your search fetched these Results");

		for (Pharmacy pharma : listOfPharmacies) {

			for (Medicine med : pharma.getMedicineList()) {

				if ((med.getMedicineName()).equals(medToSearch.getMedicineName())) {
					counter++;
					System.out.println(counter + " " + pharma.getPharmacyBrand() + " " + pharma.getLocation() + " "
							+ pharma.getTimings().toString() + " " + med.toString());

				}

			}

		}

	}

}
