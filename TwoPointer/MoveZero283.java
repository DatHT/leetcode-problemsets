// https://leetcode.com/problems/move-zeroes/description/
package TwoPointer;

public class MoveZero283 {
    public void moveZeroes(int[] nums) {
        int nextNonZero = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[nextNonZero];
                nums[nextNonZero] = temp;
                nextNonZero++;
            }
        }
    }
}
