package Arrays;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] arr)
    {
        int i=0;
        for(int j=1;j<arr.length;j++)
        {
            if(arr[i]!=arr[j])
            {
                arr[i+1] = arr[j];
                i++;
            }
        }

        return i+1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,3,4,4,4,5,5,6};
        System.out.println(removeDuplicates(arr));
        System.out.println("The modified array is: ");
        System.out.println(Arrays.toString(arr));
    }
    
}
