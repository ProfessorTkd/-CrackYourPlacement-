// Sorting
// The time complexity of this approach is O(n log n) since sorting an array of size n takes O(n log n) time.
  class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n/2];
    }
}

// Hash Map
// The time complexity of this approach is O(n)
  class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        n = n / 2;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n) {
                return entry.getKey();
            }
        }
        
        return 0;
    }
}

// Moore Voting Algorithm
// The time complexity of the Moore's Voting Algorithm is O(n)
  class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer me = null;
        
        for(int i = 0; i < nums.length; i++){
            if(count == 0){
                me = nums[i];
                count = 1;
            }else if(nums[i] == me){
                count++;
            }else{
                count--;
            }
        }
        return me;
    }
}
