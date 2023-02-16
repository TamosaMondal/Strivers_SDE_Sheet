/*Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.
*/

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer>set=new HashSet<>();
        for(int n:nums){
            set.add(n);
        }
        int longestSteak=0;
        for(int n:nums){
            if(!set.contains(n-1)){
                int curNum=n;
                int curSteak=1;
                while(set.contains(curNum+1)){
                    curNum +=1;
                    curSteak +=1;
                }
                longestSteak=Math.max(curSteak,longestSteak);
            }
        }
        return longestSteak;
    }
}
