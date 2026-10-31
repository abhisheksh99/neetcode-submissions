class Solution {
    
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chararr = str.toCharArray();
            Arrays.sort(chararr);
            String key = new String(chararr);

            // create new list if key doesn't exist
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}