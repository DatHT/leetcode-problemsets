package Interval;

import java.util.Arrays;
import java.util.Comparator;

public class NonOveralapping435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int end = intervals[0][1];
        int nonOverlappingIntervals = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                nonOverlappingIntervals++;
                end = intervals[i][1];
            }
        }
        return intervals.length - nonOverlappingIntervals;
    }
}
