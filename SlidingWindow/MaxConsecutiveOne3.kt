// https://leetcode.com/problems/max-consecutive-ones-iii/description/
fun longestOnes(nums: IntArray, k: Int): Int {
    var maxLength = 0
    var left = 0
    var countZero = 0
    for (right in nums.indices) {
        if (nums[right] == 0) countZero ++
        while (countZero > k) {
            if (nums[left] == 0) countZero --
            left ++
        }
        maxLength = max(maxLength, right - left + 1)
    } 
    return maxLength
}
