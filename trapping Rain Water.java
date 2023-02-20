/*Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
*/

class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int left=0;
        int right=n-1;
        int maxLeft=0;
        int maxRight=0;
        int res=0;
        while(left<=right){
            if(height[left]<=height[right]){
                if(height[left]>=maxLeft){
                    maxLeft=height[left];
                }else{
                    res+=maxLeft-height[left];
                }
                left++;
            }else{
                if(height[right]>=maxRight){
                    maxRight=height[right];
                }else{
                    res+=maxRight-height[right];
                }
                right--;
            }
        }
        return res;
    }
}
