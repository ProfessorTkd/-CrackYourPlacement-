class Solution {
    public int subarraysDivByK(int[] arr, int k) {
        int sum = 0, ans = 0;
        int[] marr = new int[arr.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            marr[i] = (((sum % k) + k) % k);
        }
        map.put(0,1);
        for (int i = 0; i < arr.length; i++) {
            ans += map.getOrDefault(marr[i], 0);
            map.put(marr[i],map.getOrDefault(marr[i], 0) + 1);
        }

        return ans;
    }
}

