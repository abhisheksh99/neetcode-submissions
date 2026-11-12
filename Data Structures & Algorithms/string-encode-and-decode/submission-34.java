class Solution {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs)
            sb.append(s.length()).append("#").append(s);
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();

        for (int i = 0; i < str.length();) {
            int j = str.indexOf("#", i);
            int len = Integer.parseInt(str.substring(i, j));

            res.add(str.substring(j + 1, j + 1 + len));
            i = j + 1 + len;
        }

        return res;
    }
}