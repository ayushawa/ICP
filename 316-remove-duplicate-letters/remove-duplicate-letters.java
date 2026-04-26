class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack  = new Stack<>();
        int last[] = new int[26];
        int n = s.length();
        for(int i =0;i<n;i++){
            last[s.charAt(i)-'a'] = i;
        }

        boolean visited[] = new boolean[26];
        for(int i  = 0;i<n;i++){
            char ch = s.charAt(i);
            if(visited[ch-'a']) continue;

            while(!stack.isEmpty() && stack.peek()>ch && last[stack.peek() -'a'] > i){
                visited[stack.pop()-'a'] = false;
            }

            stack.push(ch);
            visited[ch-'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        for(char ch : stack) sb.append(ch);
        return sb.toString();
    }
}