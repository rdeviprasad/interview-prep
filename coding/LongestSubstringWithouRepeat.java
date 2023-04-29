package coding;

import java.util.HashMap;
import java.util.Map;

/*
 * Given a string s, find the length of the longest substring without repeating characters.
 */

class Solution {
	int longestSubstringWithoutRepeat(String s) {
	    int start = 0;
		int ans = 0;
		int n = s.length();
		Map<Character, Integer> characterPosition = new HashMap<>();
		for(int end = 0; end < n; end++) {
			if(characterPosition.containsKey(s.charAt(end))) {
				start = Math.max(start, characterPosition.get(s.charAt(end)) + 1);
			}
			ans = Math.max(ans, end - start + 1);
			characterPosition.put(s.charAt(end), end);
		}
		return ans;
	}
}
