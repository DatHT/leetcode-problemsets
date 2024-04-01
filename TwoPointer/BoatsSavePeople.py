
# https://leetcode.com/problems/boats-to-save-people/description/


class Solution:
    def numRescueBoats(self, people: List[int], limit: int) -> int:
        people.sort()
        left, right = 0, len(people) - 1
        count = 0
        while left <= right:
            if people[left] + people[right] > limit:
                count += 1 # right people only is added
                right -= 1
            else:
                # both left and right people area qualified
                count += 1
                left += 1
                right -= 1
        return count