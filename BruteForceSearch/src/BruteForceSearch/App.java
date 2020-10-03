package BruteForceSearch;

public class App {

	// Read Book Notes.
	public static void main(String[] args) {

		String text = "test!thisis testcanwetestthis? shouldwetestthisout";
		String pattern = "test";

		System.out.println("Calling Holczer's Brute Force Substring Search");
		System.out.println("------------------------------------------------");
		holczerBruteForce(text, pattern);

		System.out.println("");
		System.out.println("Calling Deven's Brute Force Substring Search");
		System.out.println("------------------------------------------------");

		devenBruteForce(text, pattern);
	}

	// Takes O(length(text)-O(length(pattern)))* O(length(pattern)) time i.e
	// O(N)*O(M) time
	public static void holczerBruteForce(String text, String pattern) {

		int lengthOfText = text.length();
		int lengthOfPattern = pattern.length();

		for (int i = 0; i <= lengthOfText - lengthOfPattern; i++) {

			int j;

			for (j = 0; j < lengthOfPattern; j++) {
				if (text.charAt(i + j) != pattern.charAt(j)) {
					break;
				}
			}

			if (j == lengthOfPattern)
				System.out.println("Match at : " + i); // where the match is in the text
		}

	}

	// Takes O(length(text)-O(length(pattern)))* O(length(pattern)) time i.e
	// O(N)*O(M) time
	private static void devenBruteForce(String text, String pattern) {

		int count = 0;
		for (int i = 0; i <= text.length() - pattern.length(); i++) {
			for (int j = 0; j < pattern.length(); j++) {
				if (text.charAt(i + j) != pattern.charAt(j)) {
					break;
				} else if ((text.charAt(i + j) == pattern.charAt(j)) && (j == pattern.length() - 1)) {
					// this is the case where we completely matched the pattern
					count++;
					System.out.print("Match in text from " + i + " to " + (i + j) + ". ");
					System.out.println("This is match number : " + count);
				} else
					continue;
			}
		}

	}

}
