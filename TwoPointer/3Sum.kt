// https://leetcode.com/problems/3sum/description/
fun main() {
    // Your code here
    val nums = intArrayOf(-1, 0, 1, 2, -1, -4)
    val result = threeSum(nums)
    println(result)
}

fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val result = mutableListOf<List<Int>>()
        for(i in 0 until nums.size - 2) {
            if(i > 0 && nums[i] == nums[i - 1]) continue
            var k = i + 1
            var j = nums.size - 1
            while(k < j) {
                val sum = nums[i] + nums[k] + nums[j]
                if (sum < 0) {
                    k++
                } else if (sum > 0) {
                    j--
                } else {
                    result.add(listOf(nums[i], nums[k], nums[j]))
                    while(k < j && nums[k] == nums[k + 1]) k++
                    while(k < j && nums[j] == nums[j - 1]) j--
                    k++
                    j--
                }
            }
        }
        return result
    }