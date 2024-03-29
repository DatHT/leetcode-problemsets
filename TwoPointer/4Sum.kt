// https://leetcode.com/problems/4sum/
class Solution {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        nums.sort()
        val result = mutableSetOf<List<Int>>()
        for(a in 0 until nums.size - 3) {
            if (a > 0 && nums[a] == nums[a - 1]) continue
            for(b in a + 1 until nums.size - 2) {
                var c = b + 1
                var d = nums.size - 1
                while(c < d) {
                    val sum = nums[a] + nums[b] + nums[c] + nums[d]
                    if(sum < target) {
                        c++
                    } else if( sum > target) {
                        d--
                    } else {
                        val li = mutableListOf(nums[a], nums[b], nums[c], nums[d])
                        li.sort()
                        result.add(li)
                        while(c < d && nums[c] == nums[c + 1]) c++
                        while(c < d && nums[d] == nums[d - 1]) d--
                        c++
                        d--
                    }
                }
            }
        }
        return result.toList()
    }
}

fun main() {
    val sol = Solution()
    val nums = intArrayOf(1000000000, 1000000000, 1000000000, 1000000000)
    val target = -294967296
    val result = sol.fourSum(nums, target)
    println(result)
}