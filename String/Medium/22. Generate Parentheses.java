class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        helper("",n,0,0,res);
        return res;
    }
    private void helper(String s, int n, int open, int close, List<String>res){
        if(open>n || close>open) return;
        if(open==n && close==n){
            res.add(s);
            return;
        }

        helper(s+"(",n,open+1,close,res);
        helper(s+")",n,open,close+1,res);
        }
}
