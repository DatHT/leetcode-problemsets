# https://leetcode.com/problems/top-k-frequent-elements/
import heapq
from collections import defaultdict
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq_dict = defaultdict(int)
        for item in nums:
            freq_dict[item] += 1
        
        max_heap = [(value, key) for key, value in freq_dict.items()]
        largest = heapq.nlargest(k, max_heap)
        return [ largest[i][1] for i in range(len(largest))]

    