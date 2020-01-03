package com.deven.javalearning;

public class BanyanTree extends Tree {

	String speciality;
	
	public BanyanTree(Leaves leaves, double hei) {
		super(leaves, hei);

	}
	
	public BanyanTree(Leaves leaves, double hei,String sp) {
		super(leaves, hei);
		this.speciality=sp;
		
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public double getHeight() {
		int value3 = 0;
		value3++;
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public Leaves getLeaves() {
		return leaves;
	}

	public void setLeaves(Leaves leaves) {
		this.leaves = leaves;
	}
	@Override
	public String toString() {
		return "BanyanTree [speciality=" + speciality + ", height=" + height + ", leaves=" + leaves + "]";
	}

	
	
	
}
