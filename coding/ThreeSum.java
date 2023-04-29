package coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given an array A, find all unique triplets in the array whose sum is equal to zero.
 * Example:
 * A: [1, 1, 0, -1, -2]
 * Triplets: [
 *  [-2, 1, 1],
 *  [-1, 0, 1]
 * ]
 * Note: Each triplet should be sorted. The resultant array should be sorted as well.
 */

class Solution {
	List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> answer = new ArrayList<>();
		int n = nums.length;
		if(n == 0) {
			return answer;
		}
		Arrays.sort(nums);
		for(int i = 0; i < n; i++) {
			if(i != 0 && nums[i - 1] == nums[i]) continue;
			int left = i + 1, right = n - 1;
			while(left < right) {
			  int sum = nums[i] + nums[left] + nums[right];
			  if(sum == 0) {
				List<Integer> ans = new ArrayList<>();
				ans.add(nums[i]);
				ans.add(nums[left]);
				ans.add(nums[right]);
				answer.add(ans);
				left++;
				right--;
				while(left < right && nums[left] == nums[left - 1]) left++;
			  } else if(sum > 0) {
				right--;
			  } else {
				left++;
			  }
			}
		}
		return answer;
	}
}
