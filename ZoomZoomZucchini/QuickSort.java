//Kayli Matsuyoshi, Kevin Lin, Victor Lin
//APCS2 pd1
//HW18 -- QuickSort
//2018-03-13t

/*****************************************************
* class QuickSort
* Implements quicksort algo to sort an array of ints in place
*
* 1. Summary of QuickSort algorithm:
* QSort(arr): Partition the partitions formed by parition until the array is sorted
*
* 2a. Worst pivot choice and associated runtime: Min/Max of the array O(n^2)
*
* 2b. Best pivot choice and associated runtime: Median of the array O(nlogn)
*
* 3. Approach to handling duplicate values in array: Because the pivot value is
*    eliminated from the next partitions, and duplicates will eventually be
*    chosen as the pivot, no special treatment for duplicates is necessary.
*****************************************************/

public class QuickSort
{
  //--------------v  HELPER METHODS  v--------------
  //swap values at indices x, y in array o
  public static void swap( int x, int y, int[] o ) {
    int tmp = o[x];
    o[x] = o[y];
    o[y] = tmp;
  }

  //print input array
  public static void printArr( int[] a ) {
    for ( int o : a )
    System.out.print( o + " " );
    System.out.println();
  }

  //shuffle elements of input array
  public static void shuffle( int[] d ) {
    int tmp;
    int swapPos;
    for( int i = 0; i < d.length; i++ ) {
      tmp = d[i];
      swapPos = i + (int)( (d.length - i) * Math.random() );
      swap( i, swapPos, d );
    }
  }

  //return int array of size s, with each element fr range [0,maxVal)
  public static int[] buildArray( int s, int maxVal ) {
    int[] retArr = new int[s];
    for( int i = 0; i < retArr.length; i++ )
    retArr[i] = (int)( maxVal * Math.random() );
    return retArr;
  }

  public static int partition( int arr[], int a, int b, int c)
  {
    int v = arr[c];

    swap( c, b, arr);
    int s = a;

    for( int i = a; i < b; i++ ) {
      if ( arr[i] <= v) {
        swap( i, s, arr );
        s++;}
      }
      swap(s,b,arr);

      return s;
    }//end partition
    //--------------^  HELPER METHODS  ^--------------



    /*****************************************************
    * void qsort(int[])
    * @param d -- array of ints to be sorted in place
    *****************************************************/
/*    public static void qsort( int[] d )
    {
      qsortH(d,0,d.length-1);
    }

    private static void qsortH(int[] arr, int low, int high) {
      if (low > high) return;
      int save = partition(arr,low,high,(low+high)/2);
      qsortH(arr,low,save-1);
      qsortH(arr,save+1,high);
    }*/

    public static void qsort( int[] d, int pivot){
        qsortH(d,0,d.length-1,pivot);
    }

    //you may need a helper method...

    public static void qsortH(int[] d, int low, int high,int pivot){
      if(low >= high){return;}
      int temp = partition(d,low,high,pivot);
/*      qsortH(d,low,temp-1,(low + temp -1)/2);
      qsortH(d,temp+1,high,(high + temp +1)/2);*/
      qsortH(d,low,temp-1,low);
      qsortH(d,temp+1,high,temp +1);
    }

    //main method for testing
    public static void main( String[] args )
    {
/*
      //get-it-up-and-running, static test case:
      int [] arr1 = {7,1,5,12,3};
      System.out.println("\narr1 init'd to: " );
      printArr(arr1);

      qsort( arr1 );
      System.out.println("arr1 after qsort: " );
      printArr(arr1);

      // randomly-generated arrays of n distinct vals
      int[] arrN = new int[10];
      for( int i = 0; i < arrN.length; i++ )
      arrN[i] = i;

      System.out.println("\narrN init'd to: " );
      printArr(arrN);

      shuffle(arrN);
      System.out.println("arrN post-shuffle: " );
      printArr(arrN);

      qsort( arrN );
      System.out.println("arrN after sort: " );
      printArr(arrN);
      /*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y)

      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
/*
      //get-it-up-and-running, static test case w/ dupes:
      int [] arr2 = {7,1,5,12,3,7};
      System.out.println("\narr2 init'd to: " );
      printArr(arr2);

      qsort( arr2 );
      System.out.println("arr2 after qsort: " );
      printArr(arr2);


      // arrays of randomly generated ints
      int[] arrMatey = new int[20];
      for( int i = 0; i < arrMatey.length; i++ )
      arrMatey[i] = (int)( 48 * Math.random() );

      System.out.println("\narrMatey init'd to: " );
      printArr(arrMatey);

      shuffle(arrMatey);
      System.out.println("arrMatey post-shuffle: " );
      printArr(arrMatey);

      qsort( arrMatey );
      System.out.println("arrMatey after sort: " );
      printArr(arrMatey);
            /*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y)
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    }//end main

  }//end class QuickSort
