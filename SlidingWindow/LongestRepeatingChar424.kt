// https://leetcode.com/problems/longest-repeating-character-replacement/
fun characterReplacement(s: String, k: Int): Int {
    val count = IntArray(26)
    var start = 0
    var maxCount = 0
    var maxLength = 0

    for (end in 0 until s.length) {
        maxCount = maxOf(maxCount, ++count[s[end] - 'A'])

        while (end - start + 1 - maxCount > k) {
            count[s[start] - 'A']--
            start++
        }

        maxLength = maxOf(maxLength, end - start + 1)
    }

    return maxLength
}