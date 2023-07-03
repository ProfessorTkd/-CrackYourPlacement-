class Solution {

  void sortColors(int[] nums) {

    int start = 0;
    int mid = 0;
    int end = nums.length - 1;

    while (mid <= end) {

      switch (nums[mid]) {
        case 0:
          // Swap with start index
          swap(nums, start, mid);
          mid++;
          start++;
          break;

        case 1:
          mid++;
          break;

        case 2:
          // Swap with end index
          swap(nums, mid, end);
          end--;
          break;
      }
    }

  }

  private void swap(int[] arr, int pos1, int pos2) {
    int temp = arr[pos1];
    arr[pos1] = arr[pos2];
    arr[pos2] = temp;
  }

}

class Solution {
    public void sortColors(int[] nums) {
    // 1-pass
    int p1 = 0, p2 = nums.length - 1, index = 0;
    while (index <= p2) {
        if (nums[index] == 0) {
            nums[index] = nums[p1];
            nums[p1] = 0;
            p1++;
        }
        if (nums[index] == 2) {
            nums[index] = nums[p2];
            nums[p2] = 2;
            p2--;
            index--;
        }
        index++;
    }
}
}


class Solution {
    public void sortColors(int[] nums) {
    // 2-pass 
    int count0 = 0, count1 = 0, count2 = 0;
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] == 0) {count0++;}
        if (nums[i] == 1) {count1++;}
        if (nums[i] == 2) {count2++;}
    }
    for(int i = 0; i < nums.length; i++) {
        if (i < count0) {nums[i] = 0;}
        else if (i < count0 + count1) {nums[i] = 1;}
        else {nums[i] = 2;}
    }
}
}

