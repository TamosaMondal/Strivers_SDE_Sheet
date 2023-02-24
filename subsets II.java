/*Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.
*/

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); 
        List<List<Integer>> ans = new ArrayList<>(); 
        findSubsets(0, nums, new ArrayList<>(), ans); 
        return ans; 
    }
    public static void findSubsets(int index, int[] nums, List<Integer> ds, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(ds)); 
        for(int i = index;i<nums.length;i++) {
            if(i!=index && nums[i] == nums[i-1]) continue; 
            ds.add(nums[i]); 
            findSubsets(i+1, nums, ds, ans); 
            ds.remove(ds.size() - 1);
        }
        
    }
}
