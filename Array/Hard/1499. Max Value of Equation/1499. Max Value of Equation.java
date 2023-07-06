
// Since x-array is sorted and distinct, xj > xi
// Equation -> MAX[(xj + yj) + (yi - xi)]
// We can state that till just before xj, store MAX[yi - xi] for every (xj , yj) in "diff".
// Store the result of current-pair and max(diff) in "max".
// NOTE -> If the sliding-window size crosses k, then we need to increment "s" and also e would be again s+1.

// Time complexity: 0(n)
// Space complexity: 0(1)
class Solution {
   public int findMaxValueOfEquation(int[][] a, int k) {
        int n = a.length,s=0, e=1, max=Integer.MIN_VALUE;
        int diff = a[s][1]-a[s][0];
        while(e <= n-1){
            if(s == e || a[e][0]-a[s][0]>k){
                s++;
                e=s+1;
                diff = a[s][1]-a[s][0];
            }else{
                int curr_sum = a[e][0] + a[e][1];
                max = Math.max(max, curr_sum + diff);
                diff = Math.max(diff, a[e][1] - a[e][0]);
                e++;
            }
        }
        return max;
    }
}
