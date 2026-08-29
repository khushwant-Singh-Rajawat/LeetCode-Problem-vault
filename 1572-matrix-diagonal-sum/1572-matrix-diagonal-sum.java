class Solution {
    public int diagonalSum(int[][] mat) {
        int sum=0;
        int n=mat.length;
        for(int i=0;i<n;i++)
        {
            //sum of primary diagonal
            sum=sum+mat[i][i]; //[0,0] [1,1] [2,2]

            //sum of secondary Diagonals
            sum = sum+mat[i][n-i-1];
        }
        // If the matrix is Odd 
         // Remove middle element because it was counted twice
         if(n%2!=0)
         {
            sum = sum-mat[n/2][n/2];
         }
        return sum;
    }
}