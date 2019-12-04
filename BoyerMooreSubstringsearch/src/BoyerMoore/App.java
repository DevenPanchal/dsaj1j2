package BoyerMoore;

import SubstringSearch.BoyerMoore;

public class App {

	public static void main(String[] args) {
		
		String text = "This is a test";
		String pattern = "test";
		
		BoyerMoore boyerMoore = new BoyerMoore(text, pattern);
		boyerMoore.precomputeShifts();
		System.out.println( boyerMoore.search() );

	}
}
