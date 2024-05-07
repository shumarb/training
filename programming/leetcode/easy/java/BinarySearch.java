class Solution {
    public int search(int[] nums, int target) {
        int highIndex = nums.length - 1;
        int lowIndex = 0;

        while (lowIndex <= highIndex) {
            int midIndex = (lowIndex + highIndex) / 2;
            
            if (nums[midIndex] == target) {
                return midIndex;
            } else {
                if (nums[midIndex] < target) {
                    lowIndex = midIndex + 1;
                } else {
                    highIndex = midIndex - 1;
                }
            }
        }

        return -1;
    }
}
