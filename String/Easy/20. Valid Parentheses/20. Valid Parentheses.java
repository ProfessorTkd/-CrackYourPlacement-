class Solution {
    Map<Character,Character> map=new HashMap<>();
    public boolean isValid(String s) {
        
        map.put('}','{');
        map.put(')','(');
        map.put(']','[');
        
        //Stack<Character> st=new Stack<>();
        int top=-1;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            
            if(map.containsValue(c)){
                //st.push(c);
                top=i;
            }
            else{
                if(top==-1 || map.get(c)!=s.charAt(top)){
                    return false;
                }
                else{
                    top=getTop(s,top-1);
                }
            }
        }
        
        return top==-1;
    }
    
    int getTop(String s,int index){
        int right=0;
        
        while(index>=0){
            char ch=s.charAt(index);
            if(map.containsKey(ch))// ch = is closing bracket
            {
                right++;
            }
            else{
                right--;
            }
            
            if(right<0){
                return index;
            }
            index--;
        }
        
        return -1;
    }
}


class Solution {
    public boolean isValid(String s) {
        Stack<Character> bracket = new Stack<>();
        for(int i=0 ; i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='(' || ch =='{'|| ch=='['){
                bracket.push(ch);
            }else{
                if(bracket.empty()){
                    return false;
                }
                if((bracket.peek() == '(' && ch == ')') 
                || (bracket.peek() == '{' && ch == '}') 
                ||(bracket.peek() == '[' && ch == ']')){
                    bracket.pop();
                }else{
                    return false;
                }
            }
        }
        if(bracket.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
}
