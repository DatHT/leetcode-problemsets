# https://leetcode.com/problems/sort-array-by-parity-ii/description/
class Solution:
    def sortArrayByParityII(self, nums: List[int]) -> List[int]:
        odd = []
        even = []
        for item in nums:
            if item % 2 == 0:
                even.append(item)
            else:
                odd.append(item)
        return [item for pair in zip(even, odd) for item in pair]