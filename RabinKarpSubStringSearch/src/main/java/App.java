// This code is contributed by nuclode, modified by Deven
public class App {

	// Following program is a Java implementation
	// of Rabin Karp Algorithm given in the CLRS book

	// IMPORTANT:
	// This implementation uses Hash to check whether there is a match or not.
	// If there is a hash match, the algorithm then only checks the actual
	// characters one by one, to validate the match to be sure. Else not.

	
	// Read Book Notes.
	
	// inputDictionary is the number of characters in the input alphabet
	public final static int inputDictionary = 256;

	public static void main(String[] args) {
		String text = "GEEKS FOR GEEKS";
		String pattern = "GEEK";

		// A prime number
		int prime = 101;

		// Function Call
		App a = new App();
		a.rabinKarpSubStringSearch(pattern, text, prime);
	}

	void rabinKarpSubStringSearch(String pattern, String text, int prime) {

		int N = text.length();
		int M = pattern.length();
		int i, j;
		int patternHash = 0; // hash value for pattern
		int textHash = 0; // hash value for text
		int h = 1;
		int count = 0;
		// Calculate the value of h. The value of h would become "pow(inputDictionary,
		// M-1)%prime"
		for (i = 0; i < M - 1; i++)
			h = (h * inputDictionary) % prime;

		// Once we calculate h, Calculate the hash value of pattern and first window of
		// text
		for (i = 0; i < M; i++) {
			patternHash = (inputDictionary * patternHash + pattern.charAt(i)) % prime;
			textHash = (inputDictionary * textHash + text.charAt(i)) % prime;
		}

		// Slide the pattern over text one by one
		for (i = 0; i <= N - M; i++) {

			// Check the hash values of current window of text
			// and pattern. If the hash values match then only
			// check for characters on by one
			if (patternHash == textHash) {
				/* Check for characters one by one */
				for (j = 0; j < M; j++) {
					if (text.charAt(i + j) != pattern.charAt(j))
						break;
				}

				// if patternHash == textHash and pattern[0...M-1] = text[i, i+1, ...i+M-1]
				if (j == M)
					count++;
				System.out.print("Pattern found from index " + i + " to " + (i + M - 1) + ".");
				System.out.println("  Match number : " + count);

			}

			// Calculate hash value for next window of text
			textHash = recalculateHash(text, prime, N, M, i, textHash, h);
		}
	}

	// Calculate hash value for next window of text: Remove
	// leading digit, add trailing digit
	private int recalculateHash(String text, int prime, int N, int M, int i, int textHash, int h) {
		if (i < N - M) {
			textHash = (inputDictionary * (textHash - text.charAt(i) * h) + text.charAt(i + M)) % prime;

			// We might get negative value of texthash, converting it
			// to positive
			if (textHash < 0)
				textHash = (textHash + prime);
		}
		return textHash;
	}

}
