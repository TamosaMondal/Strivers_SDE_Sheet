/*Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.
*/

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> result=new ArrayList<List<Integer>>();
        if(nums==null ||nums.length==0){
            return result;
        }
        int n=nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                long remainingSum=Long.valueOf(target) - nums[i]-nums[j];
                int left=j+1;
                int right=n-1;
                while(left<right){
                    long curSum=nums[left]+nums[right];
                    if(curSum<remainingSum){
                        left++;
                    }
                    else if(curSum>remainingSum){
                        right--;
                    }
                    else{
                        List<Integer>quad=new ArrayList<>();
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[left]);
                        quad.add(nums[right]);
                        result.add(quad);

                        while(left<right && nums[left] == quad.get(2))    ++left;//removing Duplicates for the left
                        while(left<right && nums[right] == quad.get(3))   --right;//removing Duplicates for the right
                    }
                }
                while(j+1<n && nums[j+1]==nums[j])   ++j;//Processing duplicates for j
                while(i+1<n && nums[i+1]==nums[i])   ++i;     //Processing duplicates for i
            }
            
        }
        return result;
    }
}
