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
		// TODO Auto-generated method stub
		

		//argument for input file
		String filePath = args[0]; 		// EX: accidents_small_sample.csv
		
		//arguments for user input
//		String state = args[1]; 		// EX: IL
//		String stringDate = args[2];	// EX: 2022-09-08
//		LocalDateTime date = ReportHelper.dateTimeConvert(args[2].concat(" 00:00:00"));
		
		//creates the treemap of arrays and prints the time to do so
		TreeMap<String, ArrayList<report>> report = makeTreeMap(filePath);
		
		
		//test the sorting method for arrays
		//testSort(state, report);
		
		//create a copy of the treemap and sort it 10 times, reporting the avg time to sort
		sortTimer(report);
		
	}

	/**@author abard
	 * @param report
	 * determines how long it takes to sort an arraylist
	 */
	private static void sortTimer(TreeMap<String, ArrayList<report>> report) {
//		long startTime;
//		long endTime;
//		double processTime;
//		double avgTime = 0.0;
		
			
//		partitionWithFirst(report);
			
//		partitionWithLast(report);
		
//		partitionWithMedianOf10(report);
		
//		partitionWithMedianOf3(report);
		
		partitionWithMid(report);
		
//		partitionWithRandom(report);
			
			//endTime = System.nanoTime();
			//processTime = ReportHelper.convertTime(startTime, endTime);
			//System.out.println(processTime + " Miliseconds to sort the treemap #" + i);
			//avgTime = avgTime + processTime;
		
		//avgTime = avgTime / 10.0;
		//System.out.println(avgTime + " Miliseconds on average to sort the treemap");
	}

	/**
	 * @param report
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
	 * @param report
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
			QuickSortMidNoInsertionSort.quickSort(reports.getValue());
			endTime = System.nanoTime();
			System.out.println(reports.getKey() + ": " + reports.getValue().size() + " Reports  " +
					"\t" + ReportHelper.convertTime(startTime, endTime) + " Miliseconds");
		}
		System.out.println("----------------------------");
	}

	/**
	 * @param report
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
	 * @param report
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
	 * @param report
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
	 * @param report
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
