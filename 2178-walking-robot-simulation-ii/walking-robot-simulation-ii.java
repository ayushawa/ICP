class Robot {
    int grid[][];
    int i,j;
    int n ,m;
    char dir = 'E';
    int perimeter;
     public Robot(int width, int height) {
        n = height;
        m= width;
        perimeter = 2 * (width+height)-4;
    }
    
    public void step(int num) {
        int rem = num % perimeter;

        if(rem == 0){
            if(num > 0){ 
                  if(i == 0 && j == 0) dir = 'S';
              }
            return;
         }

        num = rem;
        while(num >0){
            if(dir=='E' && j==m-1) {
                dir='N';
            }
            else if(dir=='N' && i == n-1){
                 dir = 'W';
            }
            else if(dir=='W' && j==0){
                dir='S';
            }
            else if(dir=='S' && i==0 ) dir='E';
            if(dir == 'E'){
                if(j+num<m){
                    j+=num;
                    num =0;
                }
                else {
                    int v = j;
                    j=m-1;
                    num -= (m-1-v);
                }
            }
            else if(dir == 'N'){
                if(i+num <n){
                    i+=num;
                    num =0;
                }
                else{

                 int v = i;
                i=n-1;
                num-=(n-1-v);
                }
            }
            else if(dir=='S'){
                if(i-num>=0){
                    i-=num;
                    num=0;
                }
                else {
                    int v = i;
                    i = 0;
                    num-=(v);
                }
            }
            else{
                if(j-num>=0){
                    j-=num;
                    num=0;
                }
                else{
                    int v =j;
                    j = 0;
                    num-=(v);
                }
            }
        }
    }
    
    public int[] getPos() {
        return new int[]{j,i};
    }
    
    public String getDir() {
        if(dir=='E') return "East";
        else if(dir=='N') return "North";
        else if(dir=='S') return "South";
        else return "West";
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */