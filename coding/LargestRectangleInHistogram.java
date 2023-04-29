package coding;

/*
 * You are given a list of non-negative integers denoting the bar heights of a histogram. All the bars have a width of 1. You need to find the area of the largest possible rectange in the histogram.
 */

class Solution {
	int getLargestArea(int[] heights) {
	    int ans = 0;
		int n = heights.length;
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		for(int i = 0; i <= n; i++) {
			while(!stack.isEmpty() && (i == n || heights[i] < heights[stack.peek()])) {
				int prev = stack.pop();
				if(stack.isEmpty()) {
					ans = Math.max(ans, heights[prev] * i);
				} else {
					ans = Math.max(ans, heights[prev] * (i - stack.peek() - 1));
				}
			}
			stack.push(i);
		}
		return ans;
	}
}