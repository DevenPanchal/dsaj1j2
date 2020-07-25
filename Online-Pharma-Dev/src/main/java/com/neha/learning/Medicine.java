package com.neha.learning;

public class Medicine {

	private String medicineName;
	private int quantity;

	private float cost;

	public Medicine() {}
	
	public Medicine(String medicineName, int quantity, float cost) {
		super();
		this.medicineName = medicineName;
		this.quantity = quantity;
		this.cost = cost;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Medicine [medicineName=" + medicineName + ", quantity=" + quantity + ", cost=" + cost + "]";
	}

}
