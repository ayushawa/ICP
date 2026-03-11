class Solution {
    public int partitionString(String s) {
          HashMap<Character,Integer> map = new HashMap<>();
          HashMap<Character,Integer> temp  = new HashMap<>();

          int count = 1;
          for(int i = 0;i<s.length();i++){
              char ch = s.charAt(i);
              if(map.containsKey(ch) && temp.containsKey(ch)){
                temp.clear();
                temp.put(ch,1);
                count++;
              }
              else if(map.containsKey(ch) ){
                temp.put(ch,1);
              }
              else {
                temp.put(ch,1);
                map.put(ch,1);
              }
          }
          return count;

    }
}