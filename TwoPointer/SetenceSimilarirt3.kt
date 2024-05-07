// https://leetcode.com/problems/sentence-similarity-iii/

fun areSentencesSimilar(sentence1: String, sentence2: String): Boolean {
    var s1 = sentence1.split(" ").toMutableList()
    var s2 = sentence2.split(" ").toMutableList()
    if (s1.size > s2.size) {
        // make s1 is alway smaller item
        val temp = s1
        s1 = s2
        s2 = temp
    }
    while (s1.size > 0) {
        if (s2.first() == s1.first()) {
            s1.removeFirst()
            s2.removeFirst()
        } else if (s2.last() == s1.last()) {
            s1.removeLast()
            s2.removeLast()
        } else {
            return false
        }
    }
    return true
}
