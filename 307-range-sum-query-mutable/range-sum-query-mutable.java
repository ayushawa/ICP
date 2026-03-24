class NumArray {
   static  int tree[];
    int n;
    public void buildTree(int nums[],int node,int s,int e){
        if(s == e){
            tree[node] = nums[s];
            return;
        }
        int m = s + (e-s)/2;
        buildTree(nums,2*node+1,s,m);
        buildTree(nums,2*node+2,m+1,e);
        tree[node] = tree[node*2 + 1] + tree[node*2+2];
    }
    public void updateTree(int index,int val,int node,int start,int end){
        if(start == end){
            tree[node] = val;
            return;
        }
        int mid = start +(end-start)/2;
        if(index<=mid){
            updateTree(index,val,2*node+1,start,mid);
        }
        else updateTree(index,val,2*node+2,mid+1,end);
        tree[node] = tree[node*2+1] + tree[2*node+2];
    }
    public static int query(int left,int right,int node,int start,int end){
        if(end<left || start> right) return 0;
        if(left<= start && end<= right){
            return tree[node];
        }
        int mid = start + (end-start)/2;
        int leftsum = query(left,right,2*node+1,start,mid);
        int rightsum = query(left,right,2*node+2,mid+1,end);
        return leftsum + rightsum;
    }
    public NumArray(int[] nums) {
        n = nums.length;
        tree = new int[4 * n];
        buildTree(nums,0,0,n-1);
    }
    
    public void update(int index, int val) {
        updateTree(index,val,0,0,n-1);
    }
    
    public int sumRange(int left, int right) {
        return query(left,right,0,0,n-1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */