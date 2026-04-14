class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        HashSet<String> map = new HashSet<>();
        for(String s : words){
            if(map.contains(s.substring(0,s.length()-1))){
                map.add(s);
            }
            else if(s.length() == 1){
                map.add(s);
            }
        }

        int len = 0;
        for(String key : map){
            if(len<  key.length()){
                len= key.length();
            }
        }
        ArrayList<String> l = new ArrayList<>();
        for(String s : map){
            if(s.length() == len) l.add(s);
        }
        Collections.sort(l);
        if(l.size() == 0) return "";
        return l.get(0);
    }
}