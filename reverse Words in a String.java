/*Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

 
*/

class Solution {
    public String reverseWords(String s) {
        int i=s.length()-1;
        String ans="";
        while(i>=0){
            while(i>=0 && s.charAt(i)==' ') i--;
            int j=i;
            if(i<0) break;
            while(i>=0 && s.charAt(i)!=' ') i--;
            if(ans.isEmpty()){
                ans=ans.concat(s.substring(i+1,j+1));
            }else{
                ans=ans.concat(" "+s.substring(i+1,j+1));
            }
        }
        return ans;
    }
}
