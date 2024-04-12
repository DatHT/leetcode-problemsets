# https://leetcode.com/problems/next-greater-element-iii/description/
class Solution:
    def nextGreaterElement(self, n: int) -> int:
        # convert n to list
        nums = list(str(n))
        left_pos = -1
        for i in range(len(nums) - 1, 0, -1):
            if nums[i] > nums[i - 1]:
                left_pos = i - 1
                break
        right_pos = len(nums) - 1
        while nums[left_pos] >= nums[right_pos] and left_pos != -1:
            right_pos -= 1
        nums[left_pos], nums[right_pos] = nums[right_pos], nums[left_pos]
        nums[left_pos + 1:] = nums[left_pos + 1:][::-1]
        result = int(''.join(nums))
        if result <= n or result > 2**31 - 1:
            return -1
        return result


s = Solution()
print(s.nextGreaterElement(11))