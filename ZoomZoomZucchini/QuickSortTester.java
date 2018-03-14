//Zoom Zoom Zucchini - Kayli Matsuyoshi, Kevin Lin, Victor Lin
//APCS2 --  pd1
//Lab01 --  What Does the Data Say?
//2018-03-14W

public class QuickSortTester{

    public static int[] arr;
    public static int size;
    public static double totalTime;
    
    public static int[] generateArray(int n) {
		int[] output = new int[n];
		for (int i = 0; i < n; i++) {
		    output[i] = (int) (Math.random() * 10000);
		}
		return output;
    }

    public static void addTime() {
    	arr = generateArray(size);
		for(int i = 0; i < 10; i++ ){ // 100 trials
		    double before = System.nanoTime();
		    QuickSort.qsort(arr,0);
		    totalTime += System.nanoTime()-before;
		}
    }

    public static void write() {	// displays time
		totalTime = 0;		
		addTime();
		double time = totalTime / 10;
		System.out.println(size + "," + time + "," + ( time / size ));
    }

    public static void main(String []args){
	
/*		arr = generateArray(100);

		//Warmup
		for (int i = 0; i < 100; i++) {
		    QuickSort.qsort(arr);
		}*/

		System.out.println("size,time,timePerSize");
		for( size = 1000; size <= 100000; size += 1000){
		    write();
		}
	
    } // end of main method

} // end of class QuickSortTester
