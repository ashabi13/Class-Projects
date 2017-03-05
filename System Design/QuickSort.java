public class QuickSort {
  public static void quickSort(int[] list) {
    quickSort(list, 0, list.length - 1);
  }

  private static void quickSort(int[] list, int first, int last) {
    if (last > first) {
      int pivotIndex = partition(list, first, last);
      quickSort(list, first, pivotIndex - 1);
      quickSort(list, pivotIndex + 1, last);
    }
  }

  /** Partition the array list[first..last] */
  private static int partition(int[] list, int first, int last) {
    int pivot = (list[first]+list[last]+list[(int)((first+last)/2)])/3; // Choose the first element as the pivot
    int low = first + 1; // Index for forward search
    int high = last; // Index for backward search

    while (high > low) {
      // Search forward from left
      while (low <= high && list[low] <= pivot)
        low++;

      // Search backward from right
      while (low <= high && list[high] > pivot)
        high--;

      // Swap two elements in the list
      if (high > low) {
        int temp = list[high];
        list[high] = list[low];
        list[low] = temp;
      }
    }

    while (high > first && list[high] >= pivot)
      high--;

    // Swap pivot with list[high]
    if (pivot > list[high]) {
      list[first] = list[high];
      list[high] = pivot;
      return high;
    }
    else {
      return first;
    }
  }

  /** A test method */
  public static void main(String[] args) {
    int[] list = new int[1000000];
    for(int i=0; i<1000000; i++)
      list[i] = (int) Math.round(Math.random()*5137);
    long startTime = System.currentTimeMillis();
    quickSort(list);
    long endTime = System.currentTimeMillis();
        
    //for (int i = 0; i < list.length; i++)
    //  System.out.print(list[i] + " ");
    //System.out.println();
    System.out.println("Travese time using index is " 
      + (endTime - startTime)+"\n");
    System.out.println();
  }
}