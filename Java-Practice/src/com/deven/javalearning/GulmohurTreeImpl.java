package com.deven.javalearning;

public class GulmohurTreeImpl extends Tree implements GulmohurTreeInterface {

	String speciality = null;
	String beautyFactor = null;

	public GulmohurTreeImpl(Leaves leaves, double hei) {
		super(leaves, hei);

	}

	@Override
	public String getSpeciality() {
		return speciality;
	}

	
	@Override
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
		
	}

	@Override
	public String getBeautyFactor() {
		return beautyFactor;
	}

	@Override
	public void setBeautyFactor(String beautyFactor) {
		this.beautyFactor = beautyFactor;
	}

	
	@Override
	public int beautyfactor2score(String beauFac) {

		switch (beauFac) {
		case "beautiful":
			return 10;
		case "ok":
			return 5;
		default:
			return 0;

		}

	}

	@Override
	public String toString() {
		return "GulmohurTreeImpl [speciality=" + speciality + ", beautyFactor=" + beautyFactor + ", height=" + height
				+ ", leaves=" + leaves + "]";
	}

	


}
