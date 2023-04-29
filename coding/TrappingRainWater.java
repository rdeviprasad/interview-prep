package coding;

/*
 * Given an array A where each element denotes a the height of blocks, calculate the total volume of water that can be trapped when it rains.
 * Note: one cubic block has a volume of 1 unit.
 * Example:
 * A: [ 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 ]
 * The total volume of water is 1 + 3 + 1 + 1 = 6 units.
 */

class Solution {
	int volumeOfTrappedRainWater(int[] heights) {
	    int n = heights.length;
		int start = 0;
		int end = n - 1;
		int startMax = 0;
		int endMax = 0;
		int ans = 0;
		while(start <= end) {
			if(heights[start] <= heights[end]) {
				if(heights[start] >= startMax) {
					startMax = heights[start];
				} else {
					ans += (startMax - heights[start]);
				}
				start++;
			} else {
				if(heights[end] >= endMax) {
					endMax = heights[end];
				} else {
					ans += (endMax - heights[end]);
				}
				end--;
			}
		}
		return ans;
	}
}