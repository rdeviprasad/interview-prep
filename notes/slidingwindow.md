# Sliding Window Pattern
### Definition
This technique is used on linear data structures, especially array, list or string to compute a target value for a subrange of the data structure. The target value can be maximum, minimum or anything else.

### Complexity
**Time Complexity** = O(N), where N = length of the data structure  
**Space Complexity** = O(N), where N = length of the data structure  
The space complexity mentioned above is for worst case  

### Templates
These templates are from [AlgoMonster](https://algo.monster/templates)

**Fixed size window**  
```Java
private static W slidingWindowFixed(List<T> input, int windowSize) {
    W ans = window = input[0..windowSize);
    for (int right = windowSize; right < input.size(); ++right) {
        int left = right - windowSize;
        remove input.get(left) from window
        append input.get(right) to window
        ans = optimal(ans, window);
    }
    return ans;
}
```

**Flexible size - Longest**
```Java
private static W slidingWindowFlexibleLongest(List<T> input) {
    initialize window, ans
    int left = 0;
    for (int right = 0; right < input.size(); ++right) {
        append input.get(right) to window
        while (invalid(window)) {         // update left until window is valid again
            remove input.get(left) from window
            ++left;
        }
        ans = Math.max(ans, window);           // window is guaranteed to be valid here
    }
    return ans;
}
```

** Flexible size - Shortest**
```Java
private static W slidingWindowFlexibleShortest(List<T> input) {
    initialize window, ans
    int left = 0;
    for (int right = 0; right < input.size(); ++right) {
        append input.get(right) to window
        while (valid(window)) {
            ans = Math.min(ans, window);   // window is guaranteed to be valid here
            remove input.get(left) from window
            ++left;
        }
    }
    return ans;
}
```

