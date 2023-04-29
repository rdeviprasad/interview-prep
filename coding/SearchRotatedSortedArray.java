package coding;

/*
 * You are given a list of unique integers which are sorted but rotated at some pivot. You are also given a target value and you have to find its index in the list. If it is not present in the list, return -1.
 * Example:
 * List: [4, 5, 6, 7, 1, 2, 3]
 * Target value: 6
 * Resultant index: 2
 */

class Solution {
	int getElementIndex(int[] array, int target) {
		int n = array.length;
	    int partition = getPartition(array);
		int firstHalf = getElement(array, target, 0, partition - 1);
		if(firstHalf != -1) return firstHalf;
		int secondHalf = getElement(array, target, partition, n - 1);
		return secondHalf;
	}
	
	int getElement(int[] nums, int target, int left, int right) {
		//System.out.println(left + " " + right);
		while(left <= right) {
			int mid = left + (right - left) / 2;
			if(nums[mid] == target) {
				return mid;
			} else if(nums[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}
	
	int getPartition(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		int ans = -1;
		while(left <= right) {
			int mid = left + (right - left) / 2;
			if(nums[0] <= nums[mid]) {
				left = mid + 1;
			} else {
				ans = mid;
				right = mid - 1;
			}
		}
		return ans;
	}
}
