/*Given a binary array nums, return the maximum number of consecutive 1's in the array.
*/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0;
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                count++;
            }else{
                count=0;
            }
            max=Math.max(count,max);
        }
        return max;
    }
}