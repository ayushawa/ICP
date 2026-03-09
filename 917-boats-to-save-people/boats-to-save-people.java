class Solution {
    public boolean canPlace(int people[],int m,int limit){
        int vote = 0;
        int sum = 0;
        int i = 0;
        int n = people.length;
        int j = n-1;
        while(i<=j){
            if(i != j && people[i]+people[j]<=limit){
                vote++;
                i++;
                j--;
            }
            else {
                vote++;
                j--;
            }
        }
        return vote<= m;
    }
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int  n= people.length;
        int s = n/2;
        if(n%2 != 0) s++;
        int e = n;
        int mini = n;
        while(s<=e){
            int m = s + (e-s)/2;
            if(canPlace(people,m,limit)) {
                mini = Math.min(m,mini);
                e = m-1;
            }
            else s = m+1;
        }
        return mini;

    }

}