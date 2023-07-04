// Top Down DP with HashMap - TLE
    class Solution{
        public int maxScore(int[] cardPoints, int k) {
            return helper(cardPoints, 0, cardPoints.length - 1, k);
        }

        Map<String, Integer> map = new HashMap();

        public int helper(int[] a, int l, int r, int k) {
            if (k == 0)
                return 0;
            String key = l + "|" + r;
            if (!map.containsKey(key))
                map.put(key, Math.max((a[l] + helper(a, l + 1, r, k - 1)), (a[r] + helper(a, l, r - 1, k - 1))));
            return map.get(key);
        }
    }

    // Top Down DP with Array - MLE
    class Solution{
        Integer[][] dp;

        public int maxScore(int[] cardPoints, int k) {
            dp = new Integer[cardPoints.length][cardPoints.length];
            return helper(cardPoints, 0, cardPoints.length - 1, k);
        }

        public int helper(int[] a, int l, int r, int k) {
            if (k == 0)
                return 0;
            if (dp[l][r] == null)
                dp[l][r] = Math.max((a[l] + helper(a, l + 1, r, k - 1)), (a[r] + helper(a, l, r - 1, k - 1)));
            return dp[l][r];
        }
    }

    // Optimal Solution Accepted
// TC: o(k)
// SC: 0(1)
    class Solution {
        public int maxScore(int[] cardPoints, int k) {
            int sum = 0, n = cardPoints.length;
            for (int i = 0; i < k; i++)
                sum += cardPoints[i];

            int maxPoints = sum;
            for (int i = k - 1; i >= 0; i--) {
                sum = sum - cardPoints[i] + cardPoints[n + i - k]; // n + k - 1 - k => n - 1
                maxPoints = Math.max(maxPoints, sum);
            }

            return maxPoints;
        }
    }

    class Solution {
        public int maxScore(int[] cardPoints, int k) {
            int n = cardPoints.length;
            int sum = 0;
            for (int c : cardPoints)
                sum += c;

            int minSubArraySum = sum;
            int currSum = 0;
            for (int i = 0; i < n; i++) {
                if (i >= n - k) {
                    minSubArraySum = Math.min(minSubArraySum, currSum);
                    currSum -= cardPoints[i - n + k];
                }
                currSum += cardPoints[i];
            }

            minSubArraySum = Math.min(minSubArraySum, currSum);

            return sum - minSubArraySum;
        }
    }
