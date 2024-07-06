import kotlin.math.max

// https://leetcode.com/problems/maximum-length-of-repeated-subarray/

fun findLength(nums1: IntArray, nums2: IntArray): Int {
    val dp = Array(nums1.size) { IntArray(nums2.size) { 0 }  }
    var result = 0
    for (i in nums1.indices) {
        for (j in nums2.indices) {
            if (nums1[i] == nums2[j]) {
                dp[i][j] += 1
                if (i > 0 && j > 0) {
                    dp[i][j] += dp[i - 1][j - 1]
                }
                result = max(result, dp[i][j])
            }
        }
    }
    return result
}

fun findLength1(nums1: IntArray, nums2: IntArray): Int {
    var maxLength = 0
    for (i in nums1.indices)  {
        var j = 0
        for (j in 0 until nums2.size) {
            if (nums1[i] == nums2[j]) {
                var k = i
                var h = j
                while (k < nums1.size && h < nums2.size && nums1[k] == nums2[h]) {
                    maxLength = max(k - i + 1, maxLength)
                    k++
                    h++
                }
            }
        }

    }
    return maxLength
}