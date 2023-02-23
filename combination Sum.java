/*Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the 
frequency
 of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
*/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        findCombinations(0,candidates,target,ans,new ArrayList());
        return ans;
    }
    public void findCombinations(int index,int[]candidates,int target,List<List<Integer>> ans,List<Integer> ds){
        if(index==candidates.length){
            if(target==0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if(candidates[index]<=target){  //PICKED AN ELEMENT
            ds.add(candidates[index]);
            findCombinations(index,candidates,target-candidates[index],ans,ds);
            ds.remove(ds.size()-1);
        }
        findCombinations(index+1,candidates,target,ans,ds);     //NOT PICKED AN ELEMENT
    }
}
