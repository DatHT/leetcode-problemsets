# https://leetcode.com/problems/reverse-words-in-a-string-iii/

class Solution {
    fun reverseWords(s: String): String {
        val result = mutableListOf<String>()
        for(word in s.split(" ")) {
            result.add(word.reversed())
        }
        return result.joinToString(" ")
    }
}