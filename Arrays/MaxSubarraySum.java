//not in sheet

package Arrays;

public class MaxSubarraySum {

    public static int maxSubarraySum(int[] arr)
    {
        int[] prefix = new int[arr.length];

        prefix[0] = arr[0];
        //calculate prefix array.
        for(int i=1;i<arr.length;i++)
        {   
            prefix[i] = prefix[i-1] + arr[i];
        }

        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            int start = i;
            int currSum = 0;
            for(int j=i;j<arr.length;j++)
            {
                int end = j;
                currSum = start == 0 ? prefix[end] : prefix[end] - prefix[start -1];
            }
            max = Math.max(max,currSum);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1,-2,6,-1,3};
        System.out.println("Max subarray sum: " + maxSubarraySum(arr));
    } 

    
}
