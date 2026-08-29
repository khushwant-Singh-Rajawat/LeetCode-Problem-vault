class Solution {
    public int maximumWealth(int[][] accounts)
     {
        int max=0;
      for(int i=0;i<accounts.length;i++) // i loop for Number of rows/customers
      {
        int sum=0;
        for(int j=0;j<accounts[i].length;j++) // j loop for Number of columns/accounts
        {
            sum +=accounts[i][j]; // sum for each customer
        } // end of j loop
        if(sum>max)
        max=sum;
      } //end of i loop  
    return max;
    }
}