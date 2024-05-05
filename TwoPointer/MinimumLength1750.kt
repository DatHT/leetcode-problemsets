
class Solution {
    fun minimumLength(s: String): Int {
        var left = 0
        var right = s.length - 1

        while (left < right && s[left] == s[right]) {
            val char = s[left]
            while (left <= right && s[left] == char) {
                left++
            }
            while (right >= left && s[right] == char) {
                right--
            }
        }

        return right - left + 1
    }
}