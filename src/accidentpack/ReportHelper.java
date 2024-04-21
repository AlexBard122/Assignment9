package accidentpack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class ReportHelper {
	
	/**
	 * @author abard
	 * counts the number of reports on and after a given date in a given state
	 * @param state
	 * @param date
	 * @param report
	 * @return int
	 */
	public static int countReports(String state, LocalDate date, TreeMap<String, TreeMap<LocalDate, List<report>>> report) {
		TreeMap<LocalDate,List<report>> map = report.get(state);
		if(map == null) {
			return 0;
		}else {
			int count = 0;
			for(LocalDate reports: map.navigableKeySet()) {
				if(reports.isAfter(date) || reports.isEqual(date)) {
					count = count + map.get(reports).size();
				}
			}
			return count;
		}
	}
	
	/**
	 * @author abard
	 * calculates elapsed time and converts it to miliseconds
	 * @param time1
	 * @param time2
	 * @return String
	 */
	public static double convertTime(long time1, long time2) {
		long elapsedTime = time2 - time1;
		double elapsedTimeSeconds;
		elapsedTimeSeconds = elapsedTime / 1000000.0;
		String returnValue = String.valueOf(elapsedTimeSeconds);
		if(returnValue.length() > 5) {
			returnValue = returnValue.substring(0, 5);
			return Double.valueOf(returnValue);
		}
		return Double.valueOf(returnValue);
	}
	
    
    /**
     * @author Devin C
     * Reads lines from a csv file and converts them to report objects
     * which are then seperated into a TreeMap of States and stored in ArrayLists
     * @param filename the path to the csv file
     * @return a map of states to tree maps of accidents
     */
    public static TreeMap<String, ArrayList<report>> readAccidentReports(String filename) {
        TreeMap<String, ArrayList<report>> stateAccidentsMap = new TreeMap<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            br.readLine(); // Skip header line
            while ((line = br.readLine()) != null) {
                report accidentReport = readfile(line);
                String state = accidentReport.getState();
                
                // Check if the state already exists in the map
                if (!stateAccidentsMap.containsKey(state)) {
                    // If not, create a new TreeMap for the state
                    stateAccidentsMap.put(state, new ArrayList<>());
                }
                               
                // Get the ArrayList corresponding to the date
                List<report> stateAccidents = stateAccidentsMap.get(state);
                
                // Add the accident report to the list
                stateAccidents.add(accidentReport);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return stateAccidentsMap;
    }
    
    /**
     * @author abard & Devin C
     * Reads lines from a csv file and converts them to report objects
     * @param line the line being read into a report object
     */
    private static report readfile(String line) {
        String[] items = line.split(",");
        String id = items[0];
        int severity = Integer.parseInt(items[1]);
        LocalDateTime startTime = dateTimeConvert(items[2]);
        LocalDateTime endTime = dateTimeConvert(items[3]);
        String street = items[4];
        String city = items[5];
        String county = items[6];
        String state = items[7];
        int temperature = Integer.parseInt(items[8].split("\\.")[0]);
        int humidity = Integer.parseInt(items[9].split("\\.")[0]);
        int visibility = Integer.parseInt(items[10].split("\\.")[0]);
        String weatherCondition = items[11];
        boolean crossing = Boolean.parseBoolean(items[12]);
        boolean sunrise = items[13].equals("Night")?true:false;
        report r = new report(id, severity, startTime, endTime, street, city, county, state,
                temperature, humidity, visibility, weatherCondition, crossing, sunrise);
        return r;
    }
    
    //  Taken from Dr. Behrooz Mansouri and modified to use LocalDateTime by Devin
    
    //  Create a formatter with the specific date-time format
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    /**
     * @author Dr. Behrooz Mansouri & Devin C
     * This method takes in the string representation of dateTime and return LocalDateTime object
     * @param dateTimeString
     * @return
     */
    public static LocalDateTime dateTimeConvert(String dateTimeString)
    {
        // for some of the instances the after seconds there are 0s; this line will remove them
        dateTimeString = dateTimeString.split("\\.")[0];

        // Parse the string using the formatter
        LocalDateTime localDateTime;
        try {
            localDateTime = LocalDateTime.parse(dateTimeString, formatter);
          } catch (Exception e) {
            // Handle parsing exception, e.g., invalid format, invalid date
            System.err.println("Error parsing date-time string: " + e.getMessage());
            localDateTime = null;
          }
        return localDateTime;
    }
}
