class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char st = t.charAt(i);
            map.put(sc, map.getOrDefault(sc, 0) + 1);
            map.put(st, map.getOrDefault(st, 0) - 1);
        }

        for(int count : map.values()) {
            if(count != 0) {
                return false;
            }
        }

        return true;
    }
}
