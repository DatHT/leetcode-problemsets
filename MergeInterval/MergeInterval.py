# https://leetcode.com/problems/merge-intervals/
from typing import List
class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        if len(intervals) < 2:
            return intervals
        # sort list by the first element of sub list
        intervals.sort(key=lambda x : x[0])
        # define a result merge interval
        merge_interval = []
        # get start point of first interval
        start = intervals[0][0]
        end = intervals[0][1]
        # interate through the intervals with the index from 1 to the end
        for i in range(1, len(intervals)):
            check_interval = intervals[i]
            # check if the end of current interval is greater than the start of next interval or not
            if check_interval[0] <= end:
                # get a new end
                end = max(end, check_interval[1])
            else:
                # add the interval to the result merge interval
                merge_interval.append([start, end])
                # assign new start and end
                start = check_interval[0]
                end = check_interval[1]
        # add the last interval to the result merge interval
        merge_interval.append([start, end])
        return merge_interval


if __name__ == "__main__":
    s = Solution()
    print(s.merge([[1,3],[2,6],[8,10],[15,18]]))