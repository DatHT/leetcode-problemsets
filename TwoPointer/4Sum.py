from typing import List
class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        nums.sort()
        result = set()
        for a in range(len(nums) - 3):
            if a > 0 and nums[a] == nums[a - 1]: continue
            for b in range(a + 1, len(nums) - 2):
                c = b + 1
                d = len(nums) - 1
                while c < d:
                    sum = nums[a] + nums[b] + nums[c] + nums[d]
                    if sum < target:
                        c += 1
                    elif sum > target:
                        d -= 1
                    else:
                        li = [nums[a], nums[b], nums[c], nums[d]]
                        li.sort()
                        result.add(tuple(li))
                        while c < d and nums[c] == nums[c + 1]: c += 1
                        while c < d and nums[d] == nums[d - 1]: d -= 1
                        c += 1
                        d -= 1
        return result
    
s = Solution()
print(s.fourSum([-2,-1,-1,1,1,2,2], 0)) 