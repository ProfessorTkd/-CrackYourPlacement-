class Solution {
    String[] ones = {"" , "One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten",
    "Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        
    String[] tens = {"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        
    int billion = 1000000000;
    int million = 1000000;
    int thousand = 1000;
    int hundred = 100;
    public String numberToWords(int n)
    {
        if(n == 0)
            return "Zero";
        
        return backtrack(n).trim();
    }
    private String backtrack(int n)
    {
        StringBuilder sb = new StringBuilder();
        
        if(n >= billion)
            sb.append(backtrack(n/billion)).append(" Billion ").append(backtrack(n%billion));
        else if(n >= million)
            sb.append(backtrack(n/million)).append(" Million ").append(backtrack(n%million));
        else if(n >= thousand)
            sb.append(backtrack(n/thousand)).append(" Thousand ").append(backtrack(n%thousand));
        else if(n >= hundred)
            sb.append(backtrack(n/hundred)).append(" Hundred ").append(backtrack(n%hundred));
        else if(n >= 20)
            sb.append(tens[n/10]).append(" ").append(backtrack(n%10));
        else
            sb.append(ones[n]);
        
        return sb.toString().trim();
    }
}
