from typing import List
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        nums.sort()
        my_set = set(nums)
        print(my_set)
        result = []
        for i in range(0, len(my_set)):
            if i + 1 not in my_set:
                result.append(i + 1)
        return result

if __name__ == "__main__":
    s = Solution()
    print(s.findDisappearedNumbers([4,3,2,7,8,2,3,1])) # [5,6]