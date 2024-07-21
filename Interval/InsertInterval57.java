package Interval;

import java.util.*;

public class InsertInterval57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        for (int[] interval : intervals) {
            if (newInterval[0] <= interval[1] && newInterval[0] >= interval[0] && newInterval[1] >= interval[1]) {
                newInterval = new int[] {interval[0], newInterval[1]};
            } else if (newInterval[0] <= interval[0] && newInterval[1] >= interval[0] && newInterval[1] <= interval[1]) {
                newInterval = new int[] {newInterval[0], interval[1]};
            } else if (newInterval[0] >= interval[0] && newInterval[1] <= interval[1]) {
                newInterval = new int[] {interval[0], interval[1]};
            } else if (newInterval[0] <= interval[0] && interval[1] <= newInterval[1]) {
                // do no thing
            } else {
                result.add(interval);
            }
        }
        result.add(newInterval);
        result.sort(Comparator.comparingInt(a -> a[0]));
        return result.toArray(new int[0][]);
    }
}
