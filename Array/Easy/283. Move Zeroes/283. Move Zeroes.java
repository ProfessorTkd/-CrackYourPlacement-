//1:
class Solution {
     public void moveZeroes(int[] nums) {
        int WinSize = 0; 
        for (int i=0;i<nums.length;i++){
	        if (nums[i]==0){
                WinSize++; 
            }
            else if (WinSize > 0) {
	            int t = nums[i];
	            nums[i]=0;
	            nums[i-WinSize]=t;
            }
        }
    }
}


//2:
class Solution {
    public void moveZeroes(int[] nums) {
        int j=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=0){
                nums[j] = nums[i];
                j++;
            }
        }
        while(j<nums.length){
            nums[j++] = 0;
        }
    }
}
