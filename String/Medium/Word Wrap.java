class Solution
{
    public int recSol(int i,int rem,int []arr,int k,int n,int dp[][])
    {
       if(i == n)return 0;
       if(dp[i+1][rem+1] != -1){
           return dp[i+1][rem+1];
       }
       int ans;
       if(arr[i]>rem){
           ans = (rem+1)*(rem+1)+recSol(i+1,k-arr[i]-1,arr,k,n,dp);
       }else{
           int c1 = (rem+1)*(rem+1)+recSol(i+1,k-arr[i]-1,arr,k,n,dp);
           int c2 = recSol(i+1,rem-arr[i]-1,arr,k,n,dp);
           ans = Math.min(c1,c2);
       }
       dp[i+1][rem+1] = ans;
       return ans;
   }
    
    public int solveWordWrap (int[] nums, int k)
    {
       int n = nums.length;
       
       int dp[][] = new int [n+5][k+5];
       for(int i =0;i<n+5;i++){
           for(int j =0;j<k+5;j++){
               dp[i][j] = -1;
           }
       }
       return recSol(0,k,nums,k,n,dp);
   }
}
