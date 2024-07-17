package Arrays;

import java.util.HashSet;

public class FindDuplicateNumber {

    //using hashset
    public static int findDuplicate(int[] arr)
    {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if(set.contains(arr[i]))
                return arr[i];
            else
                set.add(arr[i]);
        }

        return -1; // does not contain any duplicates
    }

    public static int findDuplicate2(int[] arr)
    {
        for(int i=0;i<arr.length;i++)
        {
            int index = Math.abs(arr[i]);
            if(arr[index] < 0)
                return index;
            arr[index] = -arr[index];
        }

        return -1;
    }
    
    public static void main(String[] args) {
        int[] arr ={1,2,3,2};
        System.out.println(findDuplicate2(arr));
        // System.out.println(findDuplicate(arr));
    }
}
