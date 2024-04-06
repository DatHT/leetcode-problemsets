# https://leetcode.com/problems/trapping-rain-water/
from typing import List
class Solution1:
    def trap(self, height: List[int]) -> int:
        count = self.calculate(height)
        if count == 0:
            reversed_height = height[::-1]
            count = self.calculate(reversed_height)
        return count
    
    def calculate(self, height: List[int]) -> int:
        count = 0
        i = 0
        while i < len(height) - 2:
            left = i
            right = i + 2
            badge = height[i + 1]
            catch_water = False
            while catch_water == False:
                if height[left] <= height[right] and height[left] > 0:
                    catch_water = True
                    count += (right - left - 1) * height[left] - badge
                    i = right
                else:
                    badge += height[right]
                    right += 1
                if right == len(height):
                    i += 1
                    break
        return count

def calculate(self, height: List[int]) -> int:
    count = 0
    i = 0
    while i < len(height) - 2:
        left = i
        right = i + 2
        badge = height[i + 1]
        catch_water = False
        while catch_water == False:
            if height[left] <= height[right] and height[left] > 0:
                catch_water = True
                count += (right - left - 1) * height[left] - badge
                i = right
            else:
                badge += height[right]
                right += 1
            if right == len(height):
                i += 1
                break
    return count
    

class Solution:
    def trap(self, height: List[int]) -> int:
        lmax, rmax = -1, -1
        left, right = 0, len(height) - 1
        count = 0
        while left < right:
            lmax = max(height[left], lmax)
            rmax = max(height[right], rmax)
            if lmax < rmax:
                count += lmax - height[left]
                left += 1
            else:
                count += rmax - height[right]
                right -= 1
        return count

    
s = Solution()
print(s.trap([0,1,0,2,1,0,1,3,2,1,2,1])) # 6