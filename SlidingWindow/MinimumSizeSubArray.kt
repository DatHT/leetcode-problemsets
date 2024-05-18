// https://leetcode.com/problems/minimum-size-subarray-sum/description/
fun minSubArrayLen(target: Int, nums: IntArray): Int {
    var left = 0
    var minLength = Int.MAX_VALUE
    var sumCal = 0
    for (right in nums.indices) {
        sumCal += nums[right]
        if (sumCal >= target) minLength = min(minLength, right - left + 1)
        while (sumCal > target && left < right) {
            sumCal -= nums[left]
            left += 1
            if (sumCal >= target) minLength = min(minLength, right - left + 1)
        }
    }
    if (minLength == Int.MAX_VALUE) minLength = 0
    return minLength
}