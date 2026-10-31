class Solution {
    public String encode(List<String> strs) {
        if(strs.size() == 0){
            return Character.toString((char)258);
        }
        String separate = Character.toString((char)257);
        StringBuilder sb = new StringBuilder();
        
        for (String s : strs){
            sb.append(s);
            sb.append(separate);
        }
        
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    public List<String> decode(String s) {
        if(s.equals(Character.toString((char)258))){
            return new ArrayList<>();
        }
        String separate = Character.toString((char)257);
        return Arrays.asList(s.split(separate, -1));
    }
}
