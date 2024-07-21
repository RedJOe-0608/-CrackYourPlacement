package BinarySearch;

//this question makes use of ternary search.
public class MakeAllElementsEqualWithMinCost {

    public static int computeCost(int[] arr, int x)
    {
        int cost = 0;
        for(int i=0;i<arr.length;i++)
        {
            cost+=Math.abs(arr[i] - x);
        }

        return cost;
    }

    public static int makeAllElementsEqual(int[] arr)
    {
        int low = Integer.MAX_VALUE,high = Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++)
        {
            low = Math.min(low,arr[i]);
            high = Math.max(high,arr[i]);
        }

        //the reason for this is that when high-low = 2, mid1 and mi2 values will start to repeat. If this point is doubtful to you, do a dry run.
        while((high - low) > 2)
        {
            int mid1 = low + (high - low)/3;
            int mid2 = high - (high - low)/3;

            int cost1 = computeCost(arr, mid1);
            int cost2 = computeCost(arr, mid2);

            if(cost1 < cost2)
                high = mid2;
            else
                low = mid1;
        }

        int res = computeCost(arr, low);

        for(int i=low+1;i<=high;i++)
        {
            res = Math.min(res,computeCost(arr, i));
        }

        return res;
    }

    public static void main(String[] args) {
        // int[] arr = {1,100,101};
        int[] arr = {4,6};
        System.out.println("The min cost = " + makeAllElementsEqual(arr));
    }
    
}
