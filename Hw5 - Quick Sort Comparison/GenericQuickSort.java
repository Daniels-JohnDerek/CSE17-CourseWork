/*
CSE 17
JohnDerek Daniels
Jrd319
Homework #5 DEADLINE: November 30, 2016
Program: Quick sort comparison
*/

/**
* Comparing sorts on lists of integers: 
*Size   Quick Sort (default)   Quick Sort (smart pivot)
*100000       66             77
*250000       86             112
*500000       105             121
*750000       175             192
*1000000       249             295
*/


/**
 * I would appear from the mutilple experienments that I ran that the quicksort with
 * the smart pivot is slower than the result quick sort. I do not know the reason why I got 
 * these results but i was thinking that it was maybe because since the smartSearch has to make 
 * a few more comparison that this may be the reason why it takes a little bit longer. 


/**
 * A generic implementation of the quickSearch which has the option to use
 * different means for selecting the pivot */
public class GenericQuickSort  {
  
  /**
   * The implementation for the quick search */
  public static <E extends Comparable<E>> void quickSort (E[] list, boolean smartPivot){
      quickSort(list, smartPivot, 0, list.length - 1);
  }
  
  /**
   * recursive helper method for quick sort */
  private static <E extends Comparable<E>> void quickSort (E[] list, boolean smartPivot, int first, int last){
    if(last > first){
      int pivotIndex = partition(list, smartPivot, first, last);
      quickSort(list, smartPivot, first, pivotIndex - 1);
      quickSort(list, smartPivot, pivotIndex + 1, last);
    }
  }
  
  /**
   * This method picks the pivot and  partition the list into two sets */
  private static <E extends Comparable<E>> int partition (E[] list, boolean smartPivot, int first, int last){
    Integer pivot;
    int pivotIndex;
    int low = first + 1;
    int high = last;
    
    if(smartPivot == true){
      int middle = (last + first) / 2;
      if ((Integer)(list[first]) > (Integer)(list[middle])){
        E temp = list[first];
        list[first] = list[middle];
        list[middle] = temp;
        
      }
      if ((Integer)(list[first]) > (Integer)(list[last])){
        E temp = list[first];
        list[first] = list[last];
        list[last] = temp;
        
      }
      if ((Integer)(list[middle]) > (Integer)(list[last])){
        E temp = list[middle];
        list[middle] = list[last];
        list[last] = temp;
       
      }
    
      E temp = list[middle];
      list[middle] = list[last];
      list[last] = temp;
      
      pivotIndex = first;
      
      
    }

    
    else {
      pivotIndex = first;
    }
    
    pivot = (Integer)(list[pivotIndex]);
    
    while (high >= low){
      while(low <= high && (Integer)(list[low]) <= pivot)
        low++;
      while(low <= high && (Integer)(list[high]) > pivot)
        high--;
      
      if(high >= low){
        E temp = (list[high]);
        (list[high]) = (list[low]);
        (list[low]) = temp;
        high--;
        low++;
      }
    }
    
   while (high > first && (Integer)(list[high]) >= pivot)
      high--;
    
    if (pivot > (Integer)(list[high])) {
      list[first] = list[high];
      list[high] = (E)(pivot);
      return high;
    }
    else 
      return first;
      
   } 

  /**
   * Generates the arrays with the different sizes of random integers
   * between 0 and 999999 */
  public static Integer[] makeRandomList(int size){
    Integer[] randomList = new Integer[size];
    for(int i = 0; i < size; i++){
      randomList[i] = (int)(Math.random() * 1000000);
    }
    return randomList;
  }
      
  /** 
   * Main method */
  public static void main (String[] args) {
    
    System.out.println("Comparing sorts on lists of integers: ");
    System.out.println("Size \t Quick Sort (default) \t Quick Sort (smart pivot)");
    
    
    Integer[] array1 = makeRandomList(100000);
    Integer[] array2 = new Integer[100000];
    //Makes a copy of the random array
    System.arraycopy(array1, 0, array2, 0, 100000);
    
    //Determines the time it takes for the sort to be performed
    long startTime1 = System.currentTimeMillis();
    quickSort(array1, false);
    long endTime1 = System.currentTimeMillis();
    long executionTime1 = endTime1 - startTime1;
    
    //Determines the time it takes for the sort to be performed by the second array
    long startTime2 = System.currentTimeMillis();
    quickSort(array2, true);
    long endTime2 = System.currentTimeMillis();
    long executionTime2 = endTime2 - startTime2;
    
    System.out.println("100000 \t     " +executionTime1 + " \t \t \t       " + executionTime2);
    
    //Repeat for the remaining size arrays
    Integer[] array3 = makeRandomList(250000);
    Integer[] array4 = new Integer[250000];
    System.arraycopy(array3, 0, array4, 0, 250000);
    
    long startTime3 = System.currentTimeMillis();
    quickSort(array3, false);
    long endTime3 = System.currentTimeMillis();
    long executionTime3 = endTime3 - startTime3;
    
    long startTime4 = System.currentTimeMillis();
    quickSort(array4, true);
    long endTime4 = System.currentTimeMillis();
    long executionTime4 = endTime4 - startTime4;
    
    System.out.println("250000 \t     " +executionTime3 + " \t \t \t       " + executionTime4);
    
    //Repeat for the remaining size arrays
    Integer[] array5 = makeRandomList(500000);
    Integer[] array6 = new Integer[500000];
    System.arraycopy(array5, 0, array6, 0, 500000);
    
    long startTime5 = System.currentTimeMillis();
    quickSort(array5, false);
    long endTime5 = System.currentTimeMillis();
    long executionTime5 = endTime5 - startTime5;
    
    long startTime6 = System.currentTimeMillis();
    quickSort(array6, true);
    long endTime6 = System.currentTimeMillis();
    long executionTime6 = endTime6 - startTime6;
    
    System.out.println("500000 \t     " +executionTime5 + " \t \t \t       " + executionTime6);
    
    //Repeat for the remaining size arrays
    Integer[] array7 = makeRandomList(750000);
    Integer[] array8 = new Integer[750000];
    System.arraycopy(array7, 0, array8, 0, 750000);
    
    long startTime7 = System.currentTimeMillis();
    quickSort(array7, false);
    long endTime7 = System.currentTimeMillis();
    long executionTime7 = endTime7 - startTime7;
    
    long startTime8 = System.currentTimeMillis();
    quickSort(array8, true);
    long endTime8 = System.currentTimeMillis();
    long executionTime8 = endTime8 - startTime8;
    
    System.out.println("750000 \t     " +executionTime7 + " \t \t \t       " + executionTime8);
    
    //Repeat for the remaining size arrays
    Integer[] array9 = makeRandomList(1000000);
    Integer[] array10 = new Integer[1000000];
    System.arraycopy(array9, 0, array10, 0, 1000000);
    
    long startTime9 = System.currentTimeMillis();
    quickSort(array9, false);
    long endTime9 = System.currentTimeMillis();
    long executionTime9 = endTime9 - startTime9;
    
    long startTime10 = System.currentTimeMillis();
    quickSort(array10, true);
    long endTime10 = System.currentTimeMillis();
    long executionTime10 = endTime10 - startTime10;
    
    System.out.println("1000000 \t     " +executionTime9 + " \t \t \t       " + executionTime10);
      
    
  }
   
  
    
  }
  
  
  