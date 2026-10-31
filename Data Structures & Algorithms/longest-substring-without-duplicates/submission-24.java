class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0) return 0;


        HashSet<Character> seen = new HashSet<>();
        int left=0,right=0,ans=0;

        while(right<s.length()){
            char c = s.charAt(right);
            while(seen.contains(c)){
                seen.remove(s.charAt(left));
                left++;
            }
            seen.add(c);
            ans=Math.max(ans,right-left+1);
            right++;
        }
        return ans;
    }
}
