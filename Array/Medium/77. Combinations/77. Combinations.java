// Time complexity:
// O(NK)
// Space complexity:
// O(N + K)
class Solution {
    List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> combine(int n, int k) {
        backTracking(new ArrayList<Integer>(), new boolean[n + 1], n, k, 0, 1);
        return res;
    }

    void backTracking(List<Integer> combination, boolean[] visited, int n, int k, int start, int pre){
        // Find k numbers
        if(start == k){
            res.add(new ArrayList<Integer>(combination));
            return;
        }

        for(int i = pre; i <= n; i++){
            if(visited[i]) continue;
            // Choose ith number
            visited[i] = true;
            combination.add(i);
            backTracking(combination, visited, n, k, start + 1, i + 1);
            // Quit choice 
            visited[i] = false;
            combination.remove(combination.size() - 1);
        }
    }
}
