# https://leetcode.com/problems/permutation-in-string/description/
class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        from collections import defaultdict
        table = defaultdict(int)
        for c in s1:
            table[c] += 1
        start, end  = 0, 0
        while start < len(s2):
            if s2[start] in table:
                end = start + len(s1)
            if end > len(s2):
                return False
            check_table = table.copy()
            count = 0
            for item in s2[start:end]:
                if item in check_table and check_table[item] > 0:
                    check_table[item] -= 1
                    count += 1
            if len(s1) == count:
                return True
            start += 1
        return False
        

if __name__ == "__main__":
    s = Solution()
    print(s.checkInclusion("hello", "ooolleoooleh")) # True