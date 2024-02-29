import java.util.HashMap;

class Solution {

    public int[] twoSum(int[] nums, int target) {
        HashMap <Integer, Integer> numberIndexMap = new HashMap <Integer, Integer> ();
        for (int i = 0; i < nums.length; i++) {
            int numberToFind = target - nums[i];
            if (numberIndexMap.containsKey(numberToFind)) {
                return new int[] {i, numberIndexMap.get(numberToFind)};
            }  
            numberIndexMap.put(nums[i], i);
        }
        return null;   
    }
}
