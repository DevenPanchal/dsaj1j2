package SubstringSearch;

import java.util.HashMap;
import java.util.Map;

public class BoyerMoore {

	private Map<Character, Integer> mismatchShiftsTable;
	private String text;
	private String pattern;

	public BoyerMoore(String text, String pattern) {
		this.pattern = pattern;
		this.text = text;
		this.mismatchShiftsTable = new HashMap<>();
	}

	public void precomputeShifts() {

		int lengthOfPattern = this.pattern.length();

		for (int index = 0; index < lengthOfPattern; index++) {
			char actualCharacter = this.pattern.charAt(index);
			int maxShift = Math.max(1, lengthOfPattern - index - 1);
			this.mismatchShiftsTable.put(actualCharacter, maxShift);
		}
	}

	// Takes sublinear time O(lengthofText/lengthofPattern) in the average case
	// Takes linear time O(N+M) time.
	public void search() {

		int lengthOfPattern = this.pattern.length();
		int lengthOfText = this.text.length();
		int numOfSkips;
		int count = 0;

		for (int i = 0; i <= lengthOfText - lengthOfPattern; i += numOfSkips) {

			numOfSkips = 0;

			// start j from end of pattern- i.e rightwards
			for (int j = lengthOfPattern - 1; j >= 0; j--) {

				// if there is no match,
				if (text.charAt(i + j) != pattern.charAt(j)) {

					// if character appears in Bad Match table, then skip according to table
					if (this.mismatchShiftsTable.get(text.charAt(i + j)) != null) {
						numOfSkips = this.mismatchShiftsTable.get(text.charAt(i + j));
						//System.out.println(numOfSkips);
						break;
					} else {
						// OR it does not appear in Bad Match table and so it is a wildcard.
						// if the character does not appear in the Bad match table, then skip according
						// to wildcard '*'. The numberOfSkips for anything else is equal to
						// lengthOfPattern
						numOfSkips = lengthOfPattern;
						// System.out.println(numOfSkips);
						break;
					}
				}

				// if there is a match and j is lowest i.e 0
				else if ((text.charAt(i + j) == pattern.charAt(j)) && (j == 0)) {
					count++;
					System.out.println(
							"Match from " + i + " to " + (i + (lengthOfPattern - 1 - j)) + ". Match number: " + count);

				}

				// else there is a match but j is not the lowest, so just continue checking
				// along
				else {
					numOfSkips = 1;
				}

			}

		}

	}
}
