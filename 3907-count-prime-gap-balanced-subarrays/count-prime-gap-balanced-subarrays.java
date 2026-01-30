class Solution {
    public void setPrime(boolean isPrime[],int n){
        for(int i = 2;i*i<=n;i++){
            if(isPrime[i]){
                for(int j=i*i;j<=n;j+=i){
                    isPrime[j] = false;
                }
            }
        }
    }
    public int lowerBound(int arr[],int x){
        int ans =-1;
        int s=0;
        int e = arr.length-1;
        while(s<=e){
            int m = s + (e-s)/2;
            if(arr[m]>=x){
                ans = m;
                e = m-1;
            }
            else s = m+1;
        }
        return ans;
    }
    public int primeSubarray(int[] nums, int k) {
        int n = nums.length;
        int maxi = Integer.MIN_VALUE;
        for(int x: nums){
            maxi = Math.max(maxi,x);
        }
        boolean isPrime[] = new boolean[maxi+1];
        Arrays.fill(isPrime,true);
        isPrime[0] = false;
        isPrime[1] = false;
        setPrime(isPrime,maxi);

        int pref[] = new int[n+1];
        for(int i=0;i<n;i++){
            pref[i+1] = pref[i] + (isPrime[nums[i]]== true? 1: 0);
        }

        TreeMap<Integer,Integer> map = new TreeMap<>();
        int count =0;
        int r = 0;
        for(int i =0;i<n;i++){
            while(r<n){
                if(isPrime[nums[r]]){
                    map.put(nums[r],map.getOrDefault(nums[r],0)+1);
                }

                if(!map.isEmpty() && map.lastKey() - map.firstKey()>k){
                    if(isPrime[nums[r]]){
                    int value = map.get(nums[r]);
                    if(value == 1) map.remove(nums[r]);
                    else map.put(nums[r],value-1);
                    break;
                   }
                }
                r++;
            }

            int need = pref[i]+2;
            int idx = lowerBound(pref,need);
            if(idx != -1 && idx<=r){
                count += (r-idx+1);
            }

            if(isPrime[nums[i]]){
                int value = map.get(nums[i]);
                if(value == 1) map.remove(nums[i]);
                else map.put(nums[i],value-1);
            }
        }
        return count;
    }
}