class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n=nums2.length;
       int result[]=new int[n]; 
       Stack<Integer> st=new Stack<>();
       for(int i=n-1;i>=0;i--){
        while(!st.isEmpty()&& nums2[i]>=st.peek()){
            st.pop();
        }
        if(st.isEmpty()){
            result[i]=-1;
        }else{
            result[i]=st.peek();
        }
        st.push(nums2[i]);
       }
       for(int i =0;i<nums1.length;i++){
          for(int j=0;j<n;j++){
            if(nums2[j]==nums1[i]){
                nums1[i]=result[j];
                break;
            }
          }
       }
       return nums1;
    }
}