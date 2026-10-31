// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         if (s.length() == 0) return 0;
//         if (s.length() == 1) return 1;

//         int left = 0, right = 0, maxL = 0;
//         HashSet<Character> seen = new HashSet<>();

//         while (right < s.length()) {
//             if (seen.contains(s.charAt(right))) {
//                 seen.remove(s.charAt(left));
//                 left++;
//             }
//             seen.add(s.charAt(right));
//             maxL = Math.max(maxL, right - left + 1);
//             right++;

           
//         }

//         return maxL;
//     }
// }

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        int left = 0, right = 0, maxL = 0;
        HashSet<Character> seen = new HashSet<>();

        while (right < s.length()) {
            char c = s.charAt(right);

            // Keep removing from the left until 'c' is no longer in the set
            while (seen.contains(c)) {
                seen.remove(s.charAt(left));
                left++;
            }

            seen.add(c);
            maxL = Math.max(maxL, right - left + 1);
            right++;
        }

        return maxL;
    }
}
