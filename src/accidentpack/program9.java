/**
 * 
 */
package accidentpack;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
		
		long startTime;
		long endTime;
		String processTime;

		//argument for input file
		String filePath = args[0]; 		// EX: accidents_small_sample.csv
		
		//arguments for user input
		String state = args[1]; 		// EX: IL
		String stringDate = args[2];	// EX: 2022-09-08
		LocalDateTime date = ReportHelper.dateTimeConvert(args[2].concat(" 00:00:00"));
		
		//creates the treemap of arrays and prints the time to do so
		startTime = System.nanoTime();
		TreeMap<String, ArrayList<report>> report = ReportHelper.readAccidentReports(filePath);
		endTime = System.nanoTime();
		processTime = ReportHelper.convertTime(startTime, endTime);
		System.out.println(processTime + " Miliseconds to build the treemap");
		
		//create a copy of the treemap and sort it 10 times, reporting the avg time to sort
		
		QuickSortMedianOf10.quickSort(report.get(state));
		for(report reports : report.get(state)) {
			System.out.println(reports.getStartTime());
		}
	}

}
