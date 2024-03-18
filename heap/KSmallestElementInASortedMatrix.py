# https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
import heapq
class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        flatten_arr = [item for sublist in matrix for item in sublist]
        smallest_k_list = heapq.nsmallest(k, flatten_arr)
        return smallest_k_list[k - 1]