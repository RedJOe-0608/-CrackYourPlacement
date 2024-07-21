package BinarySearch;

//smallest number in the array that is >= the target number.
public class CeilingAndFloor {

    public static int ceiling(int[] arr, int target, int start, int end)
    {
        //target element > than the largest element in the array. So ceiling does not exist.
        if(target > arr[arr.length-1])
            return -1;

        if(start <=end)
        {
            int mid = end+ (start - end)/2;

            if(target == arr[mid])
                return arr[mid];

            if(target < arr[mid])
                return ceiling(arr, target, start, mid-1);
            if(target > arr[mid])
            return ceiling(arr, target, mid+1, end);
        }

        return arr[start];
    }

    public static int floor(int[] arr, int target, int start, int end)
    {
        if(target < arr[0])
            return -1;

        if(start <=end)
        {
            int mid = end + (start - end)/2;

            if(target == arr[mid])
                return arr[mid];

            if(target < arr[mid])
                return floor(arr, target, start, mid-1);

            if(target > arr[mid])
                return floor(arr, target, mid+1, end);
        }

        return arr[end];

    }

    public static void main(String[] args) {
        int[] arr = {1,4,5,7,8,9,12,15,17};
        int target = 13;
        System.out.println("ceiling: "+ ceiling(arr, target, 0, arr.length-1));
        System.out.println("floor: " + floor(arr, target, 0, arr.length-1));
    }
    
}
