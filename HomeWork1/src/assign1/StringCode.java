package assign1;

import java.util.HashSet;
import java.util.Set;

// CS108 HW1 -- String static methods

public class StringCode {

	/**
	 * Given a string, returns the length of the largest run.
	 * A a run is a series of adajcent chars that are the same.
	 * @param str
	 * @return max run length
	 */
	public static int maxRun(String str) {
		int maxRun = 0;
		int tmpMax = 1;

		int len = str.length();

		for (int i = 0; i < len-1; i++) {
			if(str.charAt(i) == str.charAt(i+1)) {
				tmpMax++;
			} else {
				//assign maxRun, the maximun till now
				maxRun = maxRun>tmpMax?maxRun:tmpMax;
				//resetting tmpMax
				tmpMax = 1;
			}
		}

		return maxRun;
	}

	
	/**
	 * Given a string, for each digit in the original string,
	 * replaces the digit with that many occurrences of the character
	 * following. So the string "a3tx2z" yields "attttxzzz".
	 * @param str
	 * @return blown up string
	 */
	public static String blowup(String str) {

		StringBuilder retStr = new StringBuilder();

		//length of str
		int len = str.length();


		for (int i = 0; i<len; i++) {
			//Get char at ith position
			char currChar = str.charAt(i);

			//if current character is number the append next character that many time
			if(currChar >= '0' && currChar <= '9') {
				//check for len-1 as we will access i+1 index
				while(currChar-- > '0' && i != len-1) {
					retStr.append(str.charAt(i+1));
				}
			} else {
				//else append that character as it is
				retStr.append(currChar);
			}
		}


		return retStr.toString();
	}
	
	/**
	 * Given 2 strings, consider all the substrings within them
	 * of length len. Returns true if there are any such substrings
	 * which appear in both strings.
	 * Compute this in linear time using a HashSet. Len will be 1 or more.
	 */
	public static boolean stringIntersect(String a, String b, int len) {

		int lena = a.length();
		int lenb = b.length();

		//base case where string is empty
		if(a.equals("") || b.equals(""))
			return false;

		//base case where len is greater than length of string
		if(lena < len || lenb < len)
			return false;

		HashSet<String> hashSet = new HashSet<>();

		//populate hashSet with subtring of String a of length len
		for (int i = 0; i + len <= lena; i++) {
			hashSet.add(a.substring(i, i + len));
		}

		//check for common substring
		for (int i = 0; i + len <= lenb; i++) {
			if(hashSet.contains(b.substring(i, i + len))) {
				return true;
			}
		}

		return false;
	}
}
