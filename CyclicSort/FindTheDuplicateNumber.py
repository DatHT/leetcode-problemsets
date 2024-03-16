# https://leetcode.com/problems/find-the-duplicate-number/
from typing import List
class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        from collections import defaultdict
        stored_dict = defaultdict(int)
        # add all items into stored dict
        for item in nums:
            stored_dict[item] +=1
        # if item is duplicated, then the value will greater than 1
        for k,v in stored_dict.items():
            if v > 1:
                return k