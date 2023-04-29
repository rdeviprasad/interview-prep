package coding;

/*
 * Given a matrix, if any of the cells in the matrix is 0, set all the elements in its row and column to 0.
 */

class Solution {
	void setRowColumnZeroes(int[][] matrix){
	    int height = matrix.length;
		if(height == 0) return;
		int width = matrix[0].length;
		boolean firstRowHasZeros = false;
		for(int col = 0; col < width; col++) {
			if(matrix[0][col] == 0) {
				firstRowHasZeros = true;
				break;
			}
		}
		for(int row = 0; row < height; row++) {
			for(int col = 0; col < width; col++) {
				if(matrix[row][col] == 0) {
					matrix[0][col] = 0;
				}
			}
		}
		for(int row = 1; row < height; row++) {
			boolean containsZero = false;
			for(int col = 0; col < width; col++) {
				if(matrix[row][col] == 0) {
					containsZero = true;
					break;
				}
			}
			for(int col = 0; col < width; col++) {
				if(containsZero || matrix[0][col] == 0) {
					matrix[row][col] = 0;
				}
			}
		}
		if(firstRowHasZeros) {
			for(int col = 0; col < width; col++) {
				matrix[0][col] = 0;
			}
		}
	}
}