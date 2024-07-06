import kotlin.math.abs

// https://leetcode.com/problems/contains-duplicate-iii/description/
fun containsNearbyAlmostDuplicate(nums: IntArray, indexDiff: Int, valueDiff: Int): Boolean {
    val buckets = mutableMapOf<Int, Int>()
    for (i in nums.indices) {
        // calculate the bucket
        var b = nums[i] / (valueDiff + 1)
        if (nums[i] < 0) b --

        if (buckets.containsKey(b)) return true
        else {
            buckets[b] = nums[i]
            // check neightboring bucket if it has the condition that less than valueDiff
            if(buckets.containsKey(b - 1) && abs(nums[i] - buckets.getOrDefault(b - 1, 0)) <= valueDiff) return true
            if(buckets.containsKey(b + 1) && abs(nums[i] - buckets.getOrDefault(b + 1, 0)) <= valueDiff) return true

            if (buckets.size > indexDiff) {
                var keyToRemove = nums[i - indexDiff] / (valueDiff + 1)
                if (nums[i - indexDiff] < 0) keyToRemove --
                buckets.remove(keyToRemove)
            }
        }
    }
    return false
}