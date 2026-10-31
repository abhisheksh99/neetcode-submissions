class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<>();
        int left=0,right=0,maxCount=0,maxLen=0;
        while(right<s.length()){
            char c=s.charAt(right);
            map.put(c,map.getOrDefault(c,0)+1);
            maxCount=Math.max(maxCount,map.get(c));

            while(right-left+1-maxCount>k){
                char leftChar=s.charAt(left);
                map.put(leftChar,map.get(leftChar)-1);
                left++;
            }
            maxLen=Math.max(maxLen,right-left+1);
            right++;
        }
        return maxLen;
    }
}
