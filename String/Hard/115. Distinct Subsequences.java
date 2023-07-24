// 1)Recursive Solution
//     Time Complexity: O(N*M) => Reason: There are N*M states therefore at max ‘N*M’ new problems will be solved.
//     Space Complexity: O(N*M) + O(N+M) => Reason: We are using a recursion stack space(O(N+M)) and a 2D array ( O(N*M)).
class Solution {
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
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]);
            else
                dp[i][j] = dp[i-1][j];
        }
    }
    
    
    return dp[n][m];
} 
}


// 2)Tabulation 
//     Time Complexity: O(N*M) => Reason: There are two nested loops
//     Space Complexity: O(N*M) => Reason: We are using an external array of size ‘N*M’. Stack Space is eliminated.
class Solution {
    public int prime =(int)(Math.pow(10,9)+7);
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


// 3)Space Optimization
//     Time Complexity: O(N*M) => Reason: There are two nested loops.
//     Space Complexity: O(M) => Reason: We are using an external array of size ‘M+1’ to store only one row.
class Solution {
    
public int prime =(int)(Math.pow(10,9)+7);
    public int numDistinct(String s1, String s2) {
    // Write your code here.
    int n = s1.length();
    int m = s2.length();
    int[] prev=new int[m+1];
    prev[0]=1;
    
    for(int i=1;i<n+1;i++){
        for(int j=m;j>=1;j--){ // Reverse direction
            
            if(s1.charAt(i-1)==s2.charAt(j-1))
                prev[j] = (prev[j-1] + prev[j])%prime;
            else
                prev[j] = prev[j]; //can omit this statemwnt
        }
    }
    return prev[m];
} 
}
