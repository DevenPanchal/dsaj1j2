package BoyerMoore;

import SubstringSearch.BoyerMoore;

public class App {

	// Read Book Notes
	public static void main(String[] args) {

		String text = "Get the chocolate,melt the chocolate,use the chocolate,add the chocolate in cake";
		String pattern = "chocolate";

		BoyerMoore boyerMoore = new BoyerMoore(text, pattern);
		boyerMoore.precomputeShifts(); // Build Bad Match or Mismatch table
		boyerMoore.search();
		System.out.println("end..");
	}
}
