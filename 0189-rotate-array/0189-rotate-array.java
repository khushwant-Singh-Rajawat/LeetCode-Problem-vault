class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length; // where n is the length of the array
        k=k%n;
        int[] temp=new int[n]; // create a new array
        for(int i=0;i<n;i++)
        {
            temp[(i+k)%n]=nums[i];
        }
        for(int i=0;i<n;i++)
        {
            nums[i]=temp[i];
        }    
    }
}