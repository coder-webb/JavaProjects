// Codey Webb

public class Sorting {

    // Used in all reverse sorting methods to track total comparisons performed. It is printed and reset at the end of each method.
    static long count = 0;

    public static void main(String[] args) {

        // Array of strings to be sorted
        String[] strArr = {"ape", "Cat", "bow", "cat", "bow", "Cat", "dog", "eel"};
        
        // Sort the array
        QuickReverseSort(strArr);
        // MergeReverseSort(strArr);
        // SelectionReverseSort(strArr);
        // BubbleReverseSort(strArr);
        
        PrintArray(strArr); // print elements of the array
    }

    public static void QuickReverseSort(String[] arr)
    {
        QuickReverseSortHelper(arr, 0, arr.length-1);
        System.out.println(count); // Print current value of count
        count = 0; // Reset count to 0
    }
    public static void QuickReverseSortHelper(String[] arr, int startIdx, int endIdx)
    {  
        if(startIdx < endIdx)//does my slice have at least 2 elements?
        {
            int p = QuickReverseSortPartition(arr, startIdx, endIdx); //partition, returns the new index for pivot element
            QuickReverseSortHelper(arr, startIdx, p-1); //sort the first "half" !!! could be empty!!!
            QuickReverseSortHelper(arr, p+1, endIdx); //sort the second "half" !!! could be empty!!!
        }
    }
    public static int QuickReverseSortPartition(String[] arr,  int startIdx, int endIdx)
    {
        String pivot = arr[endIdx];
        int i = startIdx-1;

        //traverse the slice
        for(int j = startIdx; j < endIdx; j++)
        {
            // if element j has a greater than or equal value to the element stored in pivot
            if(arr[j].compareTo(pivot) >= 0)
            {
                i++; //move i over by one
                //swap elements at position i and j
                String tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
            }
            count++; // Incremement count after each comparison
        }

        i++;

        //swap element in position i with pivot (has index endIdx)
        arr[endIdx] = arr[i];
        arr[i] = pivot;

        return i;//new position for pivot
    }

    public static void MergeReverseSort(String[] arr)
    {
        String[] tmp = new String[arr.length];
        MergeReverseSortHelper(arr, 0, arr.length-1,tmp);
        System.out.println(count); // Print current value of count
        count = 0; // Reset count to 0
    }
    public static void MergeReverseSortHelper(String[] arr, int startIdx, int endIdx, String[] tmp)
    {
        if(startIdx<endIdx) //continue dividing as long as you have at least 2 elements in the slice
        {
            int midIdx = (startIdx+endIdx)/2; //find the middle
            MergeReverseSortHelper(arr, startIdx, midIdx, tmp); //sort the first half of the slice
            MergeReverseSortHelper(arr, midIdx+1, endIdx, tmp); //sort the second half of the slice
            MergeReverse(arr, startIdx, midIdx, endIdx, tmp);//merge the two sorted half slices
        }
    }
    public static void MergeReverse(String[] arr, int startIdx, int midIdx, int endIdx, String[] tmp)
    {
        int i = startIdx;
        int k = i;
        int j = midIdx+1;

        while(i<=midIdx && j <=endIdx)//as long as there are elements in both slices
        {
            // if element i has a greater value than element j, add it to tmp
            if(arr[i].compareTo(arr[j]) > 0)
            {
                tmp[k] = arr[i];
                i++;
                k++;
            }
            else // else add element j
            {
                tmp[k] = arr[j];
                j++;
                k++;
            }
            count++; // Increment count to keep track of total comparisons performed
        }

        //one slice has been depleted ... copy down the remaining elements
        while(i<=midIdx)
        {
            tmp[k] = arr[i];
            i++;
            k++;
        }
        while(j<=endIdx)
        {
            tmp[k] = arr[j];
            j++;
            k++;
        }

        //copy elements from tmp into arr
        for(k=startIdx; k<=endIdx; k++)
        {
            arr[k] = tmp[k];
        }
    }

    public static void SelectionReverseSort(String[] array)
    {
        for(int j=0; j<array.length-1; j++)//j is the starting position for each run
        {
            int min_pos = j;//keeps track of the position for the smallest value
            //find the position of smallest value in the array
            for(int i = j+1; i<array.length;i++)
            {
                // if element i has a greater value than element j
                if(array[i].compareTo(array[min_pos]) > 0 )
                {
                    //save its position
                    min_pos = i;
                }
                count++; // Increment count to keep track of total comparisons performed
            }
            //swap elements at position j and min_pos
            String tmp= array[j];
            array[j] = array[min_pos];
            array[min_pos] = tmp;
        }
        System.out.println(count); // Print current value of count
        count = 0; // Reset count to 0
    }

    public static void BubbleReverseSort(String[] array)
    {
      for(int time = 0; time <array.length-1; time++)
      {
        boolean didSwap = false;
        //traverse the array
        for(int i=0; i<array.length - 1 - time;i++)
        {
            // if element i has a lesser value than the element after it
            if(array[i].compareTo(array[i+1]) < 0)
            {
                //swap the elements at position i and i+1
                String tmp = array[i];
                array[i] = array[i+1];
                array[i+1] = tmp;
                didSwap = true; //set the flag, we swapped values
            }
            count++; // Increment count to keep track of total comparisons performed
        }
        //did we do any swaps?
        if(!didSwap) //no swaps done in one run = array is now sorted
        {
            break; //leave the loop, we are done
        }
      }
      System.out.println(count); // Print current value of count
      count = 0; // Reset count to 0
    }

    public static void PrintArray(String[] array)
    {
        //traverse the array
        for(int i = 0; i< array.length; i++)
        {
            //display the value of the array at the index i
            System.out.print( array[i] +" ");
        }
        System.out.println();//move to the next line
    }
}