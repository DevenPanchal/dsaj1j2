package Strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Read Book Notes
public class App {

	// String -> O(N*N) time complexity but with StringBuilder -> O(N)
	// So use StringBuilder class.
	// Will take total O(N) time
	public static String revertString(String text) {

		int lengthOfText = text.length(); // O(1)
		StringBuilder reverseString = new StringBuilder();

		for (int index = lengthOfText - 1; index >= 0; index--) { // O(N)
			reverseString.append(text.charAt(index)); // O(1) . // String class would have taken O(N) here
		}

		return reverseString.toString();
	}

	private static String checkPalindrome(String string) {

		String reversedString = revertString(string);
		if (reversedString.equals(string)) {
			return string + " is a palindrome";
		}

		else
			return string + " is NOT a palindrome";
	}

	// overall running time of O(N)
	public static List<String> getSuffix(String text) {

		int lengthOfText = text.length();
		List<String> suffixList = new ArrayList<String>();

		for (int index = 0; index < lengthOfText; index++) {
			suffixList.add(text.substring(index, lengthOfText)); // O(1)
		}

		return suffixList;
	}

	// overall running time O(N)
	public static List<String> getPrefix(String text) {

		int lengthOfText = text.length();
		List<String> prefixList = new ArrayList<>();

		for (int index = 0; index < lengthOfText + 1; index++) {
			prefixList.add(text.substring(0, index)); // O(1)
		}

		return prefixList;
	}

	// O(N)
	// We have already done this problem using Trie data structure.
	public static String longestCommonPrefix(String text1, String text2) {

		// becuase we don't want to match beyond the length of the shorter string.
		int commonLength = Math.min(text1.length(), text2.length());

		for (int index = 0; index < commonLength; index++) {
			if (text1.charAt(index) != text2.charAt(index)) {
				return text1.substring(0, index); // O(1)
			}
		}

		return text1.substring(0, commonLength);
	}

	public static String longestRepeatedSubstring(String text) {

		int lengthOfText = text.length();

		List<String> suffixList = getSuffix(text); // O(N)

		// sort suffixes in ascending alphabetical order
		Collections.sort(suffixList); // O(NlogN) BUT O(N)

		System.out.println(suffixList);

		String longestSubstring = "";

		for (int i = 0; i < lengthOfText - 1; i++) {
			String tempString = longestCommonPrefix(suffixList.get(i), suffixList.get(i + 1));

			if (tempString.length() > longestSubstring.length()) {
				longestSubstring = tempString;
			}
		}

		return longestSubstring;
	}

	public static void main(String[] args) {

		System.out.println(revertString("deven"));
		System.out.println("---------------------");
		System.out.println(checkPalindrome("deven"));
		System.out.println(checkPalindrome("nitin"));
		System.out.println("---------------------");
		System.out.println(getSuffix("deven"));
		System.out.println("---------------------");
		System.out.println(getPrefix("deven"));
		System.out.println("---------------------");
		System.out.println(longestCommonPrefix("deven", "dev"));
		System.out.println(longestCommonPrefix("j", "jimmyjohns"));
		System.out.println(longestCommonPrefix("", "jimmyjohns"));
		System.out.println(longestCommonPrefix("", ""));
		System.out.println("---------------------");
		System.out.println(longestRepeatedSubstring("helloehelloejdjehello"));

	}

}
