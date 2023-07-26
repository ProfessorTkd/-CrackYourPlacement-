class Solution{
    public boolean validPalindrome(String s) {
    int i=0,j=s.length()-1;
    while(i<j)
    {
       if(s.charAt(i)!=s.charAt(j))        
//Check if characters in the middle between (i+1 & j) OR (i & j-1) are palindromes
           return isPalindrome(s,i+1,j)||isPalindrome(s,i,j-1);
        i++;
        j--;
    }
    return true;
}
public boolean isPalindrome(String s, int i, int j)
{
    while(i<j)
    {
        if(s.charAt(i)!=s.charAt(j))
            return false;
        i++;
        j--;
    }
    return true;     
 }
}
