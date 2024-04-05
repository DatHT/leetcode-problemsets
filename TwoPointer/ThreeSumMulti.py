# https://leetcode.com/problems/3sum-with-multiplicity/description/
from typing import List
import math
class Solution:
    def threeSumMulti(self, arr: List[int], target: int) -> int:
        from collections import defaultdict
        arr.sort()
        my_dict = defaultdict(int)
        count = 0
        for item in arr:
            my_dict[item] += 1
        list_keys = list(my_dict.keys())
        for i in range(len(list_keys)):
            if my_dict[list_keys[i]] > 1:
                left = i
            else:
                left = i + 1
            right = len(list_keys) - 1
            while left <= right:
                if list_keys[i] + list_keys[left] + list_keys[right] == target:
                    if left == right == i and my_dict[list_keys[i]] > 2:
                        count += math.comb(my_dict[list_keys[i]], 3)
                    elif left == right == i and my_dict[list_keys[i]] <= 2:
                        left += 1
                        right -= 1
                        continue
                    elif left == i:
                        count += my_dict[list_keys[right]] * math.comb(my_dict[list_keys[i]], 2)
                    elif left == right:
                        count += my_dict[list_keys[i]] * math.comb(my_dict[list_keys[left]], 2)
                    else:
                        count += my_dict[list_keys[i]] * my_dict[list_keys[left]] * my_dict[list_keys[right]]
                    left += 1
                    right -= 1
                elif list_keys[i] + list_keys[left] + list_keys[right] > target:
                    right -= 1
                else:
                    left += 1
        
        return count % (10**9 + 7) 

        
s = Solution()
print(s.threeSumMulti([3,3,0,0,3,2,2,3], 6)) # 12