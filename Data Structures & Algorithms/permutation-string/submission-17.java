

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        // Count frequency of characters in s1 and first window of s2
        for (char c : s1.toCharArray()) count1[c - 'a']++;
        for (int i = 0; i < s1.length(); i++) count2[s2.charAt(i) - 'a']++;

        if (Arrays.equals(count1, count2)) return true;

        // Slide the window over s2
        for (int i = s1.length(); i < s2.length(); i++) {
            count2[s2.charAt(i) - 'a']++; // Add new character
            count2[s2.charAt(i - s1.length()) - 'a']--; // Remove old character

            if (Arrays.equals(count1, count2)) return true;
        }

        return false;
    }
}
