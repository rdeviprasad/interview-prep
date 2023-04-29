/*
 * Given an array A and an integer target, find the indices of the two numbers in the array whose sum is equal to the given target.
 * Note: The problem has exactly one solution. Do not use the same element twice.
 */
package coding;

import java.util.HashMap;
import java.util.Map;

class Solution {
	int[] twoSum(int[] A, int target) {
	    Map<Integer, Integer> result = new HashMap<>();
		int n = A.length;
		for(int i = 0; i < n; i++) {
			if(result.containsKey(A[i])) {
				int[] ans = new int[2];
				ans[0] = result.get(A[i]);
				ans[1] = i;
				return ans;
			}
			result.put(target - A[i], i);
		}
		int[] dummy = new int[2];
		return dummy;
	}
}