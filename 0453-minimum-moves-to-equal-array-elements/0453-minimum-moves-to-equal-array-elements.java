class Solution {
    public int minMoves(int[] arr) {
        
        // calculate the minimun value
        int min= arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]<min)
            {
                min=arr[i];
            }
        }
        int move=0;
        // now calculate the no. of move
        for(int i=0;i<arr.length;i++)
        {
            /* using formula 
            move=move+arr[i]-min
            */
            move+= arr[i]-min;
        }
        return move;
    }
}