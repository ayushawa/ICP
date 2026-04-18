class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        int m = nums2.length;
        int n = nums1.length;
        HashMap<Integer,Integer> map= new HashMap<>();
        int j = m-1;
        while(j>=0){
            while(!st.isEmpty() && st.peek()<=nums2[j]){
                st.pop();
            }
            int val = st.isEmpty() ? - 1 : st.peek();
            map.put(nums2[j],val);
            st.push(nums2[j]);
            j--;
        }

        int ans[] = new int[n];
        for(int i =0;i<n;i++){
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}