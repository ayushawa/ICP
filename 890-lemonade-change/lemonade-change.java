class Solution {
    public boolean lemonadeChange(int[] bills) {
        int income = 0;
        int five = 0;
        int ten = 0;
        
        for(int i : bills){
            System.out.print(i);
            if(i<5) return false;
            if(i == 5){
                income+=5;
                five++;
            }
            else if( i == 10){
                income += 5;
                
                if(five>=1) five--;
                else return false; 
                ten++;
            }
            else {
                income+= 5;
                if(five>=1 && ten>=1){
                    five--;
                    ten--;
                }
                else if(five>=3){
                    five-=3;
                }
                else return false;
            }
        }
        return true;
    }
}