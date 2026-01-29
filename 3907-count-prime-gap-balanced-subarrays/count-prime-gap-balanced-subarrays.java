class Solution {
    public void setPrime(boolean isPrime[],int n){
        for(int i=2;i*i<=n;i++){
            if(isPrime[i]){
                for(int j=i*i;j<=n;j+=i){
                    isPrime[j] = false;
                }
            }
        }
    }
    public int  lowerBound(int arr[],int x){
        int i = 0;
        int j = arr.length-1;
        int ind  = -1;
        while(i<=j){
            int m = i + (j-i)/2;
            if(arr[m]>=x){
                ind = m;
                j= m-1;
            }
            else i = m+1;
        }
        return ind;
    }
    public int primeSubarray(int[] nums, int k) {
        int maxi = Integer.MIN_VALUE;
        int n= nums.length;
        for(int x: nums){
            maxi = Math.max(maxi,x);
        }
        boolean isPrime[] = new boolean[maxi+1];
        Arrays.fill(isPrime,true);
        isPrime[0] =false;
        isPrime[1] = false;
        setPrime(isPrime,maxi);

        int pref[] = new int[n+1];
        for(int i=0;i<n;i++){
            pref[i+1] = pref[i] + (isPrime[nums[i]]? 1 : 0);
        }

        int r = 0;
        int count =0;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int l=0;l<n;l++){
            while(r<n){
                if(isPrime[nums[r]]){
                     map.put(nums[r],map.getOrDefault(nums[r],0)+1);
                 }

                 if(!map.isEmpty() && map.lastKey()-map.firstKey()>k){
                    if(isPrime[nums[r]]){
                    int value = map.get(nums[r]);
                    if(value == 1) map.remove(nums[r]);
                    else map.put(nums[r],map.get(nums[r])-1);
                    break;
                    }
                 }
                 r++;
            }

            int need = pref[l]+2;
            int idx = lowerBound(pref,need);
            if(idx!=-1 && idx<=r ){
                count+= (r-idx+1);
            }

            if(isPrime[nums[l]]){
                int value = map.get(nums[l]);
                if(value == 1) map.remove(nums[l]);
                else map.put(nums[l],map.get(nums[l])-1);
            }
        }
        return count;

    }
}