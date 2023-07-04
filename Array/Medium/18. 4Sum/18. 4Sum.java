// Time Complexity: O(N3), where N = size of the array.
// Space Complexity: O(no. of quadruplets)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length; // size of the array
        List<List<Integer>> ans = new ArrayList<>();
        // sort the given array:
        Arrays.sort(nums);
        // calculating the quadruplets:
        for (int i = 0; i < n; i++) {
            // avoid the duplicates while moving i:
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < n; j++) {
                // avoid the duplicates while moving j:
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                // 2 pointers:
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    if (sum == target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        ans.add(temp);
                        k++;
                        l--;
                        // skip the duplicates:
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    } else if (sum < target) k++;
                    else l--;
                }
            }
        }
        return ans;
    }
}




class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums==null|| nums.length<4)
        return res;
        Arrays.sort(nums);
        for(int i=0; i<nums.length-3; i++){
            if(i==0 ||(i>0 && nums[i]!=nums[i-1] && i<nums.length-3) ){ // shift i , becoz we have to ignore duplicates
                for(int j=i+1;j<nums.length-2; j++){
                    if(j == i+1 || (j > i+1 && nums[j] != nums[j-1] && j<nums.length-2 )){    
                    int lo = j+1;
                    int hi = nums.length-1;
                    long sum = (long)target - (nums[i]+nums[j]);
                    while(lo < hi){
                        if(nums[lo] + nums[hi] == sum){
                            res.add(Arrays.asList(nums[i],nums[j],nums[lo],nums[hi]));
                            
                            while(lo<hi && nums[lo] == nums[lo+1]) lo++; //move lo if duplicates
                            while(lo<hi && nums[hi] == nums[hi-1]) hi--;
                            
                            lo++;
                            hi--;
                            
                            if(lo > hi) break;
                        }
                        if(nums[lo] + nums[hi] < sum)
                            lo++;
                        else if(nums[lo] + nums[hi]  > sum)
                            hi--;
                    }// end of while loop
                }
            }
        }
    }
     return res;
    }
}
