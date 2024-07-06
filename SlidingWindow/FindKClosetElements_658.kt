// https://leetcode.com/problems/find-k-closest-elements/description/
fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
    if (arr.size <= k) return arr.toList()
    val result = mutableListOf<Int>()
    for (i in 0 until k) {
        result.add(arr[i])
    }
    var right = k
    while(right < arr.size) {
        if(isACloserThanB(arr[right], result[0], x)) {
            result.add(arr[right])
            result.removeAt(0)
        }
        right ++
    }
    return result

}

fun isACloserThanB(a: Int, b: Int, x: Int): Boolean {
    return if (a == b) {
        false
    } else {
        val diffA = Math.abs(a - x)
        val diffB = Math.abs(b - x)
        if (diffA == diffB) {
            a < b
        } else {
            diffA < diffB
        }
    }
}