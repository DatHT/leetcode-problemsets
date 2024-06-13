// https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/description/
fun longestSubstring(s: String, k: Int): Int {
    val count = IntArray(26)
    var maxLength = 0
    var uniqueChars = 0

    for (c in s) {
        if (count[c - 'a'] == 0) uniqueChars++
        count[c - 'a']++
    }

    for (start in 0..s.lastIndex) {
        val currentCount = IntArray(26)
        var uniqueCharsInWindow = 0
        var validCharsInWindow = 0

        for (end in start..s.lastIndex) {
            val index = s[end] - 'a'
            if (currentCount[index] == 0) uniqueCharsInWindow++
            currentCount[index]++
            if (currentCount[index] == k) validCharsInWindow++

            if (uniqueCharsInWindow <= uniqueChars && validCharsInWindow == uniqueCharsInWindow) {
                maxLength = maxOf(maxLength, end - start + 1)
            }
        }
    }

    return maxLength
}