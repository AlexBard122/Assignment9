/**
 * 
 */
package accidentpack;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author abard
 *
 */
public class program9 {

	/**
	 * @author abard
	 * @param args
	 */
	public static void main(String[] args) throws IOException{

		//argument for input file
		String filePath = args[0]; 		// EX: accidents_small_sample.csv
		
		//creates the treemap of arrays and prints the time to do so
		TreeMap<String, ArrayList<report>> report = makeTreeMap(filePath);
		
		
		//test the sorting method for arrays
		//testSort(state, report);
		
		//create a copy of the treemap and sort it, reporting the time to sort
		sortTimer(report);
		
	}

	/**@author abard
	 * @param report
	 * determines how long it takes to sort an arraylist
	 */
	private static void sortTimer(TreeMap<String, ArrayList<report>> report) {
			
		//IMPORTANT: partitionWithFirst & partitionWithLast methods will overflow when executed after any
		//			 other method. partitionWithMedianOf10 will may not work on machines with poor RAM.
		//			 partitionWithMidOld is a version of partitionWithMid that doesn't use insertion sort.
		
		partitionWithFirst(report);
			
//		partitionWithLast(report);
		
		partitionWithMedianOf10(report);
		
		partitionWithMedianOf3(report);
		
		partitionWithMid(report);
		
		partitionWithMidOld(report);
		
		partitionWithRandom(report);
			
	}

	/**
	 * @author abard
	 * @param report
	 * prints how long it takes to sort an array with random partitioning
	 */
	private static void partitionWithRandom(TreeMap<String, ArrayList<report>> report) {
		long startTime;
		long endTime;
		TreeMap<String, ArrayList<report>> reportCopy = new TreeMap<String, ArrayList<report>>();
		reportCopy.putAll(report);
		System.out.println("Partitioning with Random:");
		for(Map.Entry<String, ArrayList<report>> reports : reportCopy.entrySet()) {
			startTime = System.nanoTime();
			//CHANGE THIS LINE TO CALL DIFFERENT SORTING ALGORITHMS
			QuickSortRandom.quickSort(reports.getValue());
			endTime = System.nanoTime();
			System.out.println(reports.getKey() + ": " + reports.getValue().size() + " Reports  " +
					"\t" + ReportHelper.convertTime(startTime, endTime) + " Miliseconds");
		}
		System.out.println("----------------------------");
	}

	/**
	 * @author abard
	 * @param report
	 * prints how long it takes to sort an array with mid partitioning
	 */
	private static void partitionWithMid(TreeMap<String, ArrayList<report>> report) {
		long startTime;
		long endTime;
		TreeMap<String, ArrayList<report>> reportCopy = new TreeMap<String, ArrayList<report>>();
		reportCopy.putAll(report);
		System.out.println("Partitioning with Mid:");
		for(Map.Entry<String, ArrayList<report>> reports : reportCopy.entrySet()) {
			startTime = System.nanoTime();
			//CHANGE THIS LINE TO CALL DIFFERENT SORTING ALGORITHMS
			QuickSortMid.quickSort(reports.getValue());
			endTime = System.nanoTime();
			System.out.println(reports.getKey() + ": " + reports.getValue().size() + " Reports  " +
					"\t" + ReportHelper.convertTime(startTime, endTime) + " Miliseconds");
		}
		System.out.println("----------------------------");
	}
	
	/**
	 * @author abard
	 * @param report
	 * prints how long it takes to sort an array with mid partitioning (Old Version)
	 */
	private static void partitionWithMidOld(TreeMap<String, ArrayList<report>> report) {
		long startTime;
		long endTime;
		TreeMap<String, ArrayList<report>> reportCopy = new TreeMap<String, ArrayList<report>>();
		reportCopy.putAll(report);
		System.out.println("Partitioning with Mid:");
		for(Map.Entry<String, ArrayList<report>> reports : reportCopy.entrySet()) {
			startTime = System.nanoTime();
			//CHANGE THIS LINE TO CALL DIFFERENT SORTING ALGORITHMS
			QuickSortMidNoInsertionSort.quickSort(reports.getValue());
			endTime = System.nanoTime();
			System.out.println(reports.getKey() + ": " + reports.getValue().size() + " Reports  " +
					"\t" + ReportHelper.convertTime(startTime, endTime) + " Miliseconds");
		}
		System.out.println("----------------------------");
	}

	/**
	 * @author abard
	 * @param report
	 * prints how long it takes to sort an array with median if 3 partitioning
	 */
	private static void partitionWithMedianOf3(TreeMap<String, ArrayList<report>> report) {
		long startTime;
		long endTime;
		TreeMap<String, ArrayList<report>> reportCopy = new TreeMap<String, ArrayList<report>>();
		reportCopy.putAll(report);
		System.out.println("Partitioning with Median of 3:");
		for(Map.Entry<String, ArrayList<report>> reports : reportCopy.entrySet()) {
			startTime = System.nanoTime();
			//CHANGE THIS LINE TO CALL DIFFERENT SORTING ALGORITHMS
			QuickSortMedianOf3.quickSort(reports.getValue());
			endTime = System.nanoTime();
			System.out.println(reports.getKey() + ": " + reports.getValue().size() + " Reports  " +
					"\t" + ReportHelper.convertTime(startTime, endTime) + " Miliseconds");
		}
		System.out.println("----------------------------");
	}

	/**
	 * @author abard
	 * @param report
	 * prints how long it takes to sort an array with median of 10 partitioning
	 */
	private static void partitionWithMedianOf10(TreeMap<String, ArrayList<report>> report) {
		long startTime;
		long endTime;
		TreeMap<String, ArrayList<report>> reportCopy = new TreeMap<String, ArrayList<report>>();
		reportCopy.putAll(report);
		System.out.println("Partitioning with Median of 10:");
		for(Map.Entry<String, ArrayList<report>> reports : reportCopy.entrySet()) {
			startTime = System.nanoTime();
			//CHANGE THIS LINE TO CALL DIFFERENT SORTING ALGORITHMS
			QuickSortMedianOf10.quickSort(reports.getValue());
			endTime = System.nanoTime();
			System.out.println(reports.getKey() + ": " + reports.getValue().size() + " Reports  " +
					"\t" + ReportHelper.convertTime(startTime, endTime) + " Miliseconds");
		}
		System.out.println("----------------------------");
	}

	/**
	 * @author abard
	 * @param report
	 * prints how long it takes to sort an array with last partitioning
	 */
	private static void partitionWithLast(TreeMap<String, ArrayList<report>> report) {
		long startTime;
		long endTime;
		TreeMap<String, ArrayList<report>> reportCopy = new TreeMap<String, ArrayList<report>>();
		reportCopy.putAll(report);
		System.out.println("Partitioning with Last:");
		for(Map.Entry<String, ArrayList<report>> reports : reportCopy.entrySet()) {
			startTime = System.nanoTime();
			//CHANGE THIS LINE TO CALL DIFFERENT SORTING ALGORITHMS
			QuickSortLast.quickSort(reports.getValue());
			endTime = System.nanoTime();
			System.out.println(reports.getKey() + ": " + reports.getValue().size() + " Reports  " +
					"\t" + ReportHelper.convertTime(startTime, endTime) + " Miliseconds");
		}
		System.out.println("----------------------------");
	}

	/**
	 * @author abard
	 * @param report
	 * Prints how long it takes to sort an array with first partitioning
	 */
	private static void partitionWithFirst(TreeMap<String, ArrayList<report>> report) {
		long startTime;
		long endTime;
		TreeMap<String, ArrayList<report>> reportCopy = new TreeMap<String, ArrayList<report>>();
		reportCopy.putAll(report);
		System.out.println("Partitioning with First:");
		for(Map.Entry<String, ArrayList<report>> reports : reportCopy.entrySet()) {
			startTime = System.nanoTime();
			//CHANGE THIS LINE TO CALL DIFFERENT SORTING ALGORITHMS
			QuickSortFirst.quickSort(reports.getValue());
			endTime = System.nanoTime();
			System.out.println(reports.getKey() + ": " + reports.getValue().size() + " Reports  " +
					"\t" + ReportHelper.convertTime(startTime, endTime) + " Miliseconds");
		}
		System.out.println("----------------------------");
	}

	/**
	 * @author abard
	 * @param filePath
	 * builds the treemap with key state and value arraylist
	 */
	private static TreeMap<String, ArrayList<report>> makeTreeMap(String filePath) {
		long startTime = System.nanoTime();
		TreeMap<String, ArrayList<report>> report = ReportHelper.readAccidentReports(filePath);
		long endTime = System.nanoTime();
		double processTime = ReportHelper.convertTime(startTime, endTime);
		System.out.println(processTime + " Miliseconds to build the treemap");
		return report;
	}

	/**
	 * @author abard
	 * @param state
	 * @param report
	 * A simple looping method to make sure an ArrayList is properly sorted
	 */
	private static void testSort(String state, TreeMap<String, ArrayList<report>> report) {
		//check to see if sorting method works
		QuickSortMedianOf10.quickSort(report.get(state));
		for(report reports : report.get(state)) {
			System.out.println(reports.getStartTime());
		}
	}
}
