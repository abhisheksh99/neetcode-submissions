class Solution {
    public boolean isAnagram(String s, String t) {
        // Check if strings are of equal length
        if(s.length() != t.length()){
            return false;
        }
        
        // Create array to count character frequencies
        int[] charcount = new int[26];
        
        // Count frequencies in both strings simultaneously
        for(int i = 0; i < s.length(); i++){
            charcount[s.charAt(i) - 'a']++;
            charcount[t.charAt(i) - 'a']--;
        }
        
        // Check if all counts are zero
        for(int count : charcount){
            if(count != 0){
                return false;
            }
        }
        
        // If we reach here, strings are anagrams
        return true;
    }
}