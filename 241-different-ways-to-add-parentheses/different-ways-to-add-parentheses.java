class Solution {
    public List<Integer>  helper(String exp){
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i<exp.length();i++){
            char ch = exp.charAt(i);
            if(ch == '+' || ch == '-' || ch == '*'){
                List<Integer> left = helper(exp.substring(0,i));
                List<Integer> right = helper(exp.substring(i+1,exp.length()));

                for(int l : left){
                    for(int r : right){
                        if(ch == '+'){
                            res.add(l + r);
                        }
                        else if(ch == '-'){
                            res.add(l-r);
                        }
                        else res.add(l * r);
                    }
                }
            }
        }
        if(res.size() == 0){
            res.add(Integer.parseInt(exp));
        }
        return res;
    }
    public List<Integer> diffWaysToCompute(String exp) {
        return helper(exp);
    }
}