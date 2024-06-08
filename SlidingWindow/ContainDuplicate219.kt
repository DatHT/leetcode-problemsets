// https://leetcode.com/problems/contains-duplicate-ii/description/

fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
    for (i in 0 until nums.size) {
        for (j in i + 1 until i + k + 1) {
            if (j < nums.size && nums[i] == nums[j]) return true
        }
    }
    return false
}