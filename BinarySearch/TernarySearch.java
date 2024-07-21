package BinarySearch;

public class TernarySearch {

    public static int ternarySearch(int[] arr, int target)
    {
        int low = 0, high = arr.length-1;

        while(low<=high)
        {
            int mid1 = low + (high - low)/3;
            int mid2 = high - (high - low)/3;

            if(target < arr[mid1])
                high = mid1-1;
            else if(target > arr[mid2])
                low = mid2+1;
            else if(target == arr[mid1])
                return mid1;
            else if(target == arr[mid2])
                return mid2;
            else
            {
                low = mid1+1;
                high = mid2-1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,4,5,6,12,13,16};
        int target = 13;

        System.out.println(ternarySearch(arr,target));
    }
    
}
