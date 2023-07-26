class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res=new ArrayList<>();
        
        int i=0;
        
        while(i<words.length){
            int wc=words[i].length();
            int can=0;
            
            int j=i+1;
            
            while(j<words.length && wc+can+words[j].length()+1<=maxWidth){
                wc+=words[j].length();
                can++;
                j++;
            }
            
            int vac=maxWidth-wc;
            int atleast=(can==0)?0:vac/can;
            int extra=(can==0)?0:vac%can;
            
            if(j==words.length){
                atleast=1;
                extra=0;
            }
            
            StringBuilder sb=new StringBuilder();
            
            int ptr=i;
            
            while(ptr<j){
                sb.append(words[ptr]);
                
                if(ptr!=j-1){
                    for(int sp=1;sp<=atleast;sp++){
                        sb.append(' ');
                    }
                
                    if(extra>0){
                        sb.append(' ');
                        extra--;
                    }
                }
                
                
                ptr++;
            }
            
            while(sb.length()<maxWidth){
                sb.append(' ');
            }
            
            res.add(sb.toString());
            i=j;
        }
        
        return res;
    }
}
