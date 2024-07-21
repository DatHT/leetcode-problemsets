// https://leetcode.com/problems/sort-colors/description/

package TwoPointer;

public class SortColor75 {
    public void sortColors(int[] nums) {
        sorttype(nums, 1);
        sorttype(nums, 2);
    }

    private void sorttype(int[] nums, int colorCode) {
        int nextNonColor = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] != colorCode) {
                int temp = nums[i];
                nums[i] = nums[nextNonColor];
                nums[nextNonColor] = temp;
                nextNonColor++;
            }
        }
    }
}
