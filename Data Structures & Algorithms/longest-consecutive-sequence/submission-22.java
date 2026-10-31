class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> seen  = new HashSet<>();

        for(int num:nums){
            seen.add(num);
        }

        int longest=0;
        for(int num:seen){
            if(!seen.contains(num-1)){
                int length=1;
                while(seen.contains(num+length)){
                    length++;
                }
            longest = Math.max(longest,length);    
            }
            
        }
        return longest;
    }
}
