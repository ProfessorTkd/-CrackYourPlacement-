// 1:Brute Force
// Time complexity: O(n^2)
// Space complexity: O(1)
class Solution {
    public int findDuplicate(int[] nums) {
    for(int i = 0; i< nums.length; i++){
        for(int j = i + 1; j < nums.length; j++){
            if(nums[i] == nums[j]){
                return nums[i];
            }
        }
    }
    return nums.length;
  }
}


// 2: HashSet
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
  public int findDuplicate(int[] nums) {
    Set<Integer> set = new HashSet<>();
        for(int num:nums){
            if(!set.add(num)){
                return num;
            }
        }
    return nums.length;
  }
}  
  
// 3. Sorting
// Time complexity: O(nlogn)
// Space complexity: O(logn)
class Solution {
  public int findDuplicate(int[] nums) {
    Arrays.sort(nums);
    for(int i = 0; i < nums.length - 1; i++){
        if(nums[i] == nums[i + 1]){
            return nums[i];
        }
    }
    return nums.length;
  }
}


// 4. Binary Search
// Time complexity: O(nlogn)
// Space complexity: O(1)
class Solution {
   public int findDuplicate(int[] nums) {
     int low = 0,high = nums.length - 1,cnt;
        while(low <= high){
            int mid = low + (high - low)/2;
            cnt = 0;
            for(int num:nums){
                if(num <= mid){
                    cnt++;
                }
            }
            if(cnt <= mid){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
    return low; 
   }
}



// 5. Counting
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
  public int findDuplicate(int[] nums) {
    int count[] = new int [nums.length];
    for(int i = 0; i<nums.length; i++){
        count[nums[i]]++;
        if(count[nums[i]] > 1){
            return nums[i];
        } 
    }
    return nums.length;
  }
}


// 6: Two Pointer
// Time complexity: O(N)
// Space complexity: O(1)
class Solution {
    public int findDuplicate(int[] nums) {
        int slow=nums[0];
        int fast=nums[0];
        do{
            slow=nums[slow];
            fast=nums[nums[fast]];
        }while(slow!=fast);
        fast=nums[0];
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }
}
