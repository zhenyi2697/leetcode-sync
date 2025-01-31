class Solution {
    // Boyer-Moore Voting Algorithm
    public int majorityElement(int[] nums) {
        Integer candidate = null;
        int count = 0;
        for(int n : nums) {
            if (count == 0) {
                candidate = n;
            }
            count += (candidate == n) ? 1 : -1;
        }

        return candidate;
    }
}