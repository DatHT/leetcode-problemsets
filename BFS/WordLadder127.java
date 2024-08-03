package BFS;

// https://leetcode.com/problems/word-ladder/description/

import java.util.*;
import java.util.List;

public class WordLadder127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return  0;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> visited = new HashSet<>();
        set.add(beginWord);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i ++) {
                String word = queue.poll();
                if (word.equals(endWord)) return level;
                for (int j = 0; j < word.length(); j ++) {
                    for (int c = 'a'; c <= 'z'; c++) {
                        char arr[] = word.toCharArray();
                        arr[j] = (char) c;
                        String newWord = new String(arr);
                        if (set.contains(newWord) && !visited.contains(newWord)) {
                            queue.add(newWord);
                            visited.add(newWord);
                        }
                    }
                }
            }
            level ++;
        }
        return 0;
    }


    public static void main(String[] args) {
        WordLadder127 w = new WordLadder127();
        System.out.println(w.ladderLength("hit", "cog", List.of("hot","dot","dog","lot","log","cog")));
    }
}
