# https://leetcode.com/problems/subsets/description/

from typing import List
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        power_set = []
        subset = []
        self.backtrack(nums, 0, power_set, subset)
        return power_set

    def backtrack(self, nums, start, power_set, subset):
        power_set.append(subset[:])
        for i in range(start, len(nums)):
            subset.append(nums[i])
            self.backtrack(nums, i + 1, power_set, subset)
            subset.pop()
    

if __name__ == "__main__":
    s = Solution()
    print(s.subsets([0])) # [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]