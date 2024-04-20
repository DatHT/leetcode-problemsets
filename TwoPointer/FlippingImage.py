# https://leetcode.com/problems/flipping-an-image/
from typing import List
class Solution:
    def flipAndInvertImage(self, image: List[List[int]]) -> List[List[int]]:
        n = len(image)
        for i in range(n):
            l, r = 0, n - 1
            while l <= r:
                image[i][l], image[i][r] = self.invertValue(image[i][r]), self.invertValue(image[i][l])
                l += 1
                r -= 1
        return image


    def invertValue(self, value) -> int:
        if value == 0:
            return 1
        else:
            return 0



s = Solution()
print(s.flipAndInvertImage([[1,1,0],[1,0,1],[0,0,0]])) # [[1,0,0],[0,1,0],[1,1,1]]