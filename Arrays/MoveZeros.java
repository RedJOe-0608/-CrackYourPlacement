package Arrays;

import java.util.Arrays;

public class MoveZeros {

    public static void moveZeros(int[] arr)
    {
        int i = 0;

        while(i<arr.length && arr[i] !=0)
        {
            i++;
        }

        if(i==arr.length)
            return;

        for(int j=i+1;j<arr.length;j++)
        {   
            if(arr[j] !=0)
            {
                //swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,4,4,2,0,1,0,0,3,0,8,9};
        System.out.println(Arrays.toString(arr));
        moveZeros(arr);
        System.out.println(Arrays.toString(arr));

    }
    
}
