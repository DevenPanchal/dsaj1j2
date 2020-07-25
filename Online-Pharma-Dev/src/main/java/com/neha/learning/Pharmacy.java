package com.neha.learning;

import java.util.*;

public class Pharmacy {

	String location;
	String pharmacyBrand;
	ArrayList<Medicine> medicineList = new ArrayList<Medicine>();
	Timings timings = new Timings();

	public Pharmacy(String location, String pharmacyBrand, ArrayList<Medicine> medicineList) {

		this.location = location;
		this.pharmacyBrand = pharmacyBrand;
		this.medicineList = medicineList;
		timings.setOpeningTime();
		timings.setClosingTime();
		timings.setFunctioningHours();
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPharmacyBrand() {
		return pharmacyBrand;
	}

	public void setPharmacyBrand(String pharmacyBrand) {
		this.pharmacyBrand = pharmacyBrand;
	}

	public ArrayList<Medicine> getMedicineList() {
		return medicineList;
	}

	public void setMedicineList(ArrayList<Medicine> medicineList) {
		this.medicineList = medicineList;
	}

	public Timings getTimings() {
		return timings;
	}

	public void setTimings() {

		timings.setOpeningTime();
		timings.setClosingTime();
		timings.setFunctioningHours();

	}

	@Override
	public String toString() {
		return "Pharmacy [location=" + location + ", pharmacyBrand=" + pharmacyBrand + ", medicineList=" + medicineList
				+ ", timings=" + timings + "]";
	}

}
