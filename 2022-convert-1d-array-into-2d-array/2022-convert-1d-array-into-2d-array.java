class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int[][] result=new int[m][n];
        int k=0;
        // If array size is not equal to rows × columns, return empty array
        if (original.length != m * n) // length =2 ,m*n=1, 2 != 1
        {
            return new int[0][0];
        }
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                result[i][j]=original[k];
                k++;
            }
        }
        return result;
    }
}