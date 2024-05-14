// https://leetcode.com/problems/maximum-subarray/
// Kanade's Althorithm

import kotlin.math.max

fun main(args: Array<String>) {
    println(maxSubArray(intArrayOf(1, -1, 1)))
}

fun maxSubArray(nums: IntArray): Int {
    var localMax = 0
    var globalMax = Int.MIN_VALUE
    var start = 0
    var end = 0
    var tempStart = 0
    for (i in nums.indices) {
        localMax = max(nums[i], nums[i] + localMax)
        if (localMax > globalMax) {
            globalMax = localMax
            start = tempStart
            end = i
        }
        if (localMax < 0) tempStart = i + 1
    }
    for (i in start..end) print("${nums[i]} ")
    println()
    return globalMax

}