class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map =new HashMap<>();

        for(String word:strs){
            char[] chars=word.toCharArray();
            Arrays.sort(chars);
            String sortedWords = new String(chars);
            if(!map.containsKey(sortedWords)){
                map.put(sortedWords,new ArrayList<>());
            }
            map.get(sortedWords).add(word);
        }

        return new ArrayList<>(map.values());
        
    }
}
