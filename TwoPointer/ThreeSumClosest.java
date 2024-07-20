package TwoPointer;

import java.util.Arrays;
// https://leetcode.com/problems/3sum-closest/description/

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            while (j < nums.length && k > i && j < k) {
                int cal = nums[i] + nums[j] + nums[k];
                if (cal - target > 0) {
                    k--;
                } else if (cal - target < 0) {
                    j++;
                } else {
                    return target;
                }
                if (Math.abs(result - target) > Math.abs(cal - target)) result = cal;
            }
        }
        return result;
    }
}
