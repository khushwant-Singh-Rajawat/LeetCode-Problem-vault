class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        // for(int i=0;i<matrix.length;i++)
        // {
        //     for(int j=0;j<matrix[0].length;j++)
        //     {
        //         if(matrix[i][j]==target)
        //         {
        //             return true;
        //         }
        //     }
        // }
        // return false;   
        // THIS HAS TIME COMPLEXITY O(M*N);

        int rows=matrix.length;
        int cols=matrix[0].length;
        int start=0;
        int end= rows*cols-1; // r=3 c=4 end=12-1=11
        while(start<=end)
        {
           int  mid=start+(end-start)/12;
            int row=mid/cols;
            int col=mid%cols;
            if(matrix[row][col]==target)
            {
                return true;
            }
            else if(matrix[row][col]<target)
            {
                start=mid+1;
            }
            else
            {
                end=mid-1;
            }
        }
        return false;
    }
}