package coding;

import java.util.ArrayDeque;

/*
 * Given a string with the just the six characters - ‘(’, ‘)’, ‘{’, ‘}’, ‘[’ and ‘]’. Determine if the string is balanced.
 * A string is balanced if all brackets exist in pairs and are closed in the correct order.
 * Example: 
 * String: ({})[]
 * Result: Balanced
 * String: {()})(
 * Result: Not Balanced
 * String: {(})[]
 * Result: Not Balanced
 */

class Solution {
	boolean isBalancedParentheses(String str) {
	    ArrayDeque<Character> stack = new ArrayDeque<>();
		for (int i = 0; i < str.length(); i++) {
            char rev = reversedBracket(str.charAt(i));
            if(isLeftBracket(str.charAt(i))) {
                stack.push(str.charAt(i));
            } else if(stack.isEmpty() || stack.pop() != rev) {
                return false;
            }
        }
        return stack.isEmpty();
	}
	
	private static boolean isLeftBracket(char charAt) {
        return charAt == '(' || charAt == '{' || charAt == '[';
    }

    private static char reversedBracket(char charAt) {
        if(charAt == '(') return ')';
        if(charAt == '[') return ']';
        if(charAt == '{') return '}';
		if(charAt == ')') return '(';
		if(charAt == '}') return '{';
		if(charAt == ']') return '[';
        throw new IllegalArgumentException("Invalid character passed in the input.");
    }
	
	boolean valid(char a, char b) {
		return (a == '(' && b == ')') || (a == '{' && b == '}') || (a == '[' && b == ']');
	}
}
