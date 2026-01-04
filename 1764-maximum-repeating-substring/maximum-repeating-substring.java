class Solution {
    public int maxRepeating(String sequence, String word) {
        StringBuilder sb = new StringBuilder(word);
        int k=0;
        while(sequence.contains(sb.toString())){
            sb.append(word);
            k++;
        }
        return k;
    }
}