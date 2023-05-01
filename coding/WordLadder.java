package coding;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordLadder {
    static class Solution {
        
        int shortestLadderLength(String start, String end, String[] list) {
            Set<String> set = new HashSet<>(Arrays.asList(list));
            if(!set.contains(end)) return 0;
            ArrayDeque<String> queue = new ArrayDeque<>();
            queue.add(start);
            int changes = 1;
            Set<String> visited = new HashSet<>();
            visited.add(start);
            
            while(!queue.isEmpty()) {
                int n = queue.size();
                for (int i = 0; i < n; i++) {
                    String word = queue.poll();
                    if(word.equals(end)) return changes;
                    for(int j = 0; j < word.length(); j++) {
                        for(int k = 'a'; k <= 'z'; k++) {
                            char[] arr = word.toCharArray();
                            arr[j] = (char) k;
                            String str = new String(arr);
                            if(set.contains(str) && !visited.contains(str)) {
                                queue.add(str);
                                visited.add(str);
                            }
                        }
                    }
                }
                changes++;
            }
            return 0;
            
        }
    }
}