class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> Set = new HashSet<>();
        for(int i=0; i<nums.length;i++){
            if(Set.contains(nums[i])){
                return true;
            }
            Set.add(nums[i]);
        }
        return false;
    }
}