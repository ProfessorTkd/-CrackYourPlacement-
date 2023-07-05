// Greedy Approach
//   Time complexity: O(n)
//   Space complexity: O(1)
class Solution {
    public boolean canJump(int[] nums) {
        int goal = nums.length-1;
       for(int i = goal-1; i >= 0; i--){
           if(nums[i]+i >= goal){
               goal = i;
           }
       }
       return goal == 0;
    }
}


class Solution {
    public boolean canJump(int[] nums) {
        int maxDist = 0;

        for(int i = 0; i < nums.length; i++) {
            if(i > maxDist) return false;
            maxDist = Math.max(i + nums[i], maxDist);
        }
        return true;
    }
}
