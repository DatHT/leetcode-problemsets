import kotlin.math.max

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
fun lengthOfLongestSubstring(s: String): Int {
    val map = mutableMapOf<Char, Int>()
    var left = 0
    var maxLength = 0
    for (right in s.indices) {
        if (s[right] in map && map[s[right]]!! >= left) {
            left = map[s[right]]!! + 1
        }

        map[s[right]] = right
        maxLength = max(maxLength, right - left + 1)
    }
    return maxLength
}

