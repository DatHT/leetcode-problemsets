class Solution {
    fun reverseWords(s: String): String {
        val list = s.trim().split("\\s+".toRegex())
        return list.reversed().joinToString(" ")
    }
}