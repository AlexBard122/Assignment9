/**
 * 
 */
package accidentpack;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
		
		startTime = System.nanoTime();
		TreeMap<String, List<report>> stateAccidentsMap = ReportHelper.readAccidentReports(filePath);
		endTime = System.nanoTime();
		processTime = ReportHelper.convertTime(startTime, endTime);
		System.out.println(processTime + " Miliseconds to build the treemap");
	}

}
