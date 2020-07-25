package com.deven.javalearning;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import com.google.gson.Gson;

public class MyFirst {

	// javac MyFirst.java
	// java MyFirst

	public static void main(String[] args) {

		int firstArgumentPassedFromCommandLine = Integer.parseInt(args[0]);

		System.out.println(firstArgumentPassedFromCommandLine + " " + "is the first argument from command line");

		int a; // Declaration
		a = 10; // Initialization

		System.out.println("The value of a is " + a);

		float f = 4.0f; // Declaration + Initialization
		double d = 5.6;
		double addition = f + f; // implicit type conversion
		float addition2 = (float) (d + d);// explicit type casting

		char[] c = { 'd', 'e', 'v', 'e', 'n' };
		String s = "deven";
		int a1[] = { 1, 7, 3, 5 }; // literal declaration of an int type array

		int[] intArray = new int[4];

		System.out.println(intArray);

		for (int m = 0; m < intArray.length; m++) {
			System.out.println(intArray[m]);
		}

		Double d2 = new Double(d);
		d2.toString();

		Tree t = new Tree(new Leaves("green"), 45.6); // declaration + allocation + initialization using constructor

		System.out.println("The leaves color is " + t.getLeaves().getColor() + " and the height is " + t.getHeight());

		System.out.println("WINTER IS HERE");

		t.setHeight(50.5);
		Leaves l = new Leaves();
		l.setColor("brown and yellowish");
		t.setLeaves(l);

		System.out.println("The CHANGED leaves color is " + t.getLeaves().getColor() + " and the CHANGED height is "
				+ t.getHeight());

		Tree.giveFruits();

		Date date = new Date();
		System.out.println(date.getYear());

		InputStream inputFile;
		OutputStream out;
		try {
			inputFile = new FileInputStream("C:\\Users\\Dev-w10\\Desktop\\hello2.txt");

			out = new FileOutputStream("C:\\Users\\Dev-w10\\Desktop\\output.txt");

			int readbyte;

			while ((readbyte = inputFile.read()) != -1) {
				out.write(readbyte);

			}
		}

		catch (FileNotFoundException e) {
			System.out.println("File Not found!!!");
		} catch (IOException e) {

			System.out.println("Input Output Exception!!!");
		}

		finally {
			System.out.println("End");
		}

		System.out.println(
				"PROGRAM IS STILL RUNNING because the Exception WAS handled. Had it not been handled, program would have stopped running.");

		/*
		 * int num[] = {1, 2, 3, 4}; System.out.println(num[4]);
		 */

		BanyanTree banyanTree = new BanyanTree(new Leaves("Dark Green"), 30.8, "It has hanging roots");

		System.out.println(banyanTree.toString());

		/*
		 * Gson g = new Gson(); BanyanTree btJson =
		 * g.fromJson(BanyanTreesJSONifiedstring, BanyanTree.class); String
		 * jsonofBanyanTree = g.toJson(btJson);
		 */

		GulmohurTreeInterface gTree = new GulmohurTreeImpl(new Leaves("Light Green"), 99.3);

		System.out.println(gTree.toString());
		gTree.setSpeciality("It has orange flowers");
		gTree.setBeautyFactor("beautiful");
		gTree.beautyfactor2score("beautiful");
		
		System.out.println(gTree.toString() + " AND the BEAUTY SCORE IS: " +  gTree.beautyfactor2score("beautiful"));

	}

}
