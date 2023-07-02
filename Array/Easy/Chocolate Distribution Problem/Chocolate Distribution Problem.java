//Chocolate Distribution Problem
// Given an array of N integers where each value represents the number of chocolates in a packet. Each packet can have a variable number of chocolates. There are m students, the task is to distribute chocolate packets such that: 

// Each student gets one packet.
// The difference between the number of chocolates in the packet with maximum chocolates and the packet with minimum chocolates given to the students is minimum.
// Examples:

// Input : arr[] = {7, 3, 2, 4, 9, 12, 56} , m = 3 
// Output: Minimum Difference is 2 

// Time Complexity: O(N*log(N))
// Space Complexit: O(1)

class Solution{
  public static int find(int[] arr, int n , int m){
    int ans = Integer.MAX_VALUE;
    Arrays.sort(arr); 

  //Window Traversal
  for(int i=0;i<n-m;i++){
    int minw = arr[i];
    int maxw = arr[i+m-1];
    int gap = maxw-minw;

    if(gap<ans){
      ans = gap;
    }
    return ans;
   }
  }
