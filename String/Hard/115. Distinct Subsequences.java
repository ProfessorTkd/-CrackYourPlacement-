class Solution {
    static int prime =(int)(Math.pow(10,9)+7);

    public int numDistinct(String s1, String s2) {
    // Write your code here.
    int n = s1.length();
    int m = s2.length();
    int dp[][]=new int[n+1][m+1];
    
    for(int i=0;i<n+1;i++){
        dp[i][0]=1;
    }
    for(int i=1;i<m+1;i++){
        dp[0][i]=0;
    }
    
    for(int i=1;i<n+1;i++){
        for(int j=1;j<m+1;j++){
            
            if(s1.charAt(i-1)==s2.charAt(j-1))
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j])%prime;
            else
                dp[i][j] = dp[i-1][j];
        }
    }
    
    
    return dp[n][m];
} 
}
