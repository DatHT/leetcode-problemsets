# https://leetcode.com/problems/kth-largest-element-in-an-array/
import heapq
from typing import List
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        min_heap = []
        for item in nums:
            heapq.heappush(min_heap, item)
            if len(min_heap) > k:
                heapq.heappop(min_heap)
        return min_heap[0]
    
s = Solution()
print(s.findKthLargest([3,2,1,5,6,4], 2)) # 5