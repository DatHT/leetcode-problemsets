# https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/description/
class Solution:
    def longestKSubstr(self, s, k):
        # code here
        if len(s) < k or len(s) == 0 or k == 0:
            return -1
        if len(set(s)) < k:
            return -1
        
        starting_point = 0
        window_len = 0
        max_len = 0
        my_dict = {}
        for i in range(len(s)):
            my_dict[s[i]] = i
            
            if len(my_dict) > k:
                starting_point = min(my_dict.values())
                del my_dict[s[starting_point]]
                starting_point += 1
            window_len = i - starting_point + 1
            max_len = max(max_len, window_len)
        return max_len



if __name__ == "__main__":
    s = Solution()
    print(s.longestKSubstr("aabacbebebe", 3)) # 7