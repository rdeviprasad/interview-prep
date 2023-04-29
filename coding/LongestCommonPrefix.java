package coding;

import java.util.Arrays;

/*
 * Given a list of strings A, find the longest common prefix among all the strings.
 * Example
 * A: [“abc”, “abef”, “abccc”, “abftg”]
 * Longest common prefix: “ab”
 */

 class Solution {
	String longestCommonPrefix(String[] str) {
	    Arrays.sort(str);
		int i = 0;
		int n = str[0].length();
		while(i < n && str[0].charAt(i) == str[str.length - 1].charAt(i)) {
			i++;
		}
		return str[0].substring(0, i);
	}
}
