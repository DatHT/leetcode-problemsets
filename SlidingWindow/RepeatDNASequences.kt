// https://leetcode.com/problems/repeated-dna-sequences/description/
fun findRepeatedDnaSequences(s: String): List<String> {
    val map = mutableMapOf<String, Int>()
    var right = 10
    var left = 0
    if (s.length < 10) return emptyList()
    while (right <= s.length) {
        val subString = s.substring(left, right)
        map[subString] = map.getOrDefault(subString, 0) + 1
        right += 1
        left += 1
    }
    return map.filter { it.value > 1 }.keys.toList()
}