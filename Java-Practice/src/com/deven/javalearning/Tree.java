package com.deven.javalearning;

class Tree {

	// properties/description - member data


	
	
//	static= 1 per class, same for each object
// final = cannot be changed. Used very often with static because static or ...
	 //common variables are usually not supposed to be changed by one object.
//volatile = go to the memory to fetch the updated value, because it might have been updated by a different thread	 

	 
	double height;
	Leaves leaves;

	 static int value5=0;
	public Tree(Leaves leaves, double hei) {
		this.leaves = leaves;
		this.height = hei;

	}

	// functions/ what can it do - member functions + creator functions
	// (constructors)

static void giveFruits() {
	 System.out.println("I am giving fruits.");
	 Tree t2 = new Tree(new Leaves(), 56.9);
	 t2.fallDown();
	value5++;
	 
 }

 void fallDown()
{value5++;
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

}
