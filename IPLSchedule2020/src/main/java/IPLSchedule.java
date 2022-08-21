package main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class IPLSchedule {
	
	private static final SimpleDateFormat SEARCH_BY_DATE_INPUT_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader =  
                new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("Select an option:\n1. Print the full schedule\n2. Search by Team\n"
					+ "3. Search by venue\n4. Search by date\n5. Exit");
			int selectedOption = Integer.parseInt(reader.readLine());
			switch (selectedOption) {
			case 1: {
				printSchedule(ScheduleData.SCHEDULES);
				break;
			}
			case 2: {
				printTeams();
				searchByTeam(Integer.parseInt(reader.readLine()));
				break;
			}
			case 3: {
				printVenues();
				searchByVenue(Integer.parseInt(reader.readLine()));
				break;
			}
			case 4: {
				System.out.println("Enter a date in dd-MM-yyyy format:");
				searchByDate(reader.readLine());
				break;
			}
			case 5: {
				System.out.println("Thank you. Have a good day!!");
				return;
			}
			default:
				continue;
			}
		}
	}
	
	public static void printTeams() {
		System.out.println("Choose a team and enter the associated number:");
		for (Integer teamId : ScheduleData.TEAMS.keySet()) {
			System.out.println(teamId + ". " + ScheduleData.TEAMS.get(teamId));
		}
	}
	
	public static void printVenues() {
		System.out.println("Choose a venue and enter the associated number:");
		for (Integer venueId : ScheduleData.VENUES.keySet()) {
			System.out.println(venueId + ". " + ScheduleData.VENUES.get(venueId));
		}
	}
	
	public static void searchByTeam(int teamId) {
		List<ScheduleData.Schedule> searchResult = new ArrayList<>();
		for (ScheduleData.Schedule schedule : ScheduleData.SCHEDULES) {
			if(schedule.team1Id == teamId || schedule.team2Id == teamId) {
				searchResult.add(schedule);
			}
		}
		printSchedule(searchResult);
	}
	
	public static void searchByVenue(int venueId) {
		List<ScheduleData.Schedule> searchResult = new ArrayList<>();
		for (ScheduleData.Schedule schedule : ScheduleData.SCHEDULES) {
			if(schedule.venueId == venueId) {
				searchResult.add(schedule);
			}
		}
		printSchedule(searchResult);
	}
	
	public static void searchByDate(String inputDateStr) {
		Date inputDate = null;
		try {
			inputDate = SEARCH_BY_DATE_INPUT_FORMAT.parse(inputDateStr);
		} catch (ParseException e) {
			System.out.println("Date Format is wrong. Please try again");
			return;
		}
		List<ScheduleData.Schedule> searchResult = new ArrayList<>();
		for (ScheduleData.Schedule schedule : ScheduleData.SCHEDULES) {
			if(getDateWithoutTime(schedule.date).equals(inputDate)) {
				searchResult.add(schedule);
			}
		}
		printSchedule(searchResult);
	}
	
	public static Date getDateWithoutTime(Date date) {
	    Calendar calendar = Calendar.getInstance();

	    calendar.setTime( date );
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	    calendar.set(Calendar.MILLISECOND, 0);

	    return calendar.getTime();
	}
	
	public static void printSchedule(List<ScheduleData.Schedule> schedules) {
		if(schedules.size() == 0) {
			System.out.println("\n\nNo results found. Please try a different criterion\n");
			return;
		}
		System.out.println("\n\nSchedule for your selected criterion:");
		repeatPrintChar('-', 74);
		printTableRow("Team 1", "Team 2", "Date", "Venue");
		for (ScheduleData.Schedule schedule : schedules) {
			printTableRow(ScheduleData.TEAMS.get(schedule.team1Id), 
					ScheduleData.TEAMS.get(schedule.team2Id), 
					schedule.date.toString(), 
					ScheduleData.VENUES.get(schedule.venueId));
		}
		System.out.println("\n");
	}
	
	public static void printTableRow(String team1, String team2, String date, String venue) {
		printVerticalLine();
		printStringWithTrailingSpaces(team1, 10);
		printVerticalLine();
		printStringWithTrailingSpaces(team2, 10);
		printVerticalLine();
		printStringWithTrailingSpaces(date, 35);
		printVerticalLine();
		printStringWithTrailingSpaces(venue, 10);
		printVerticalLine();
		System.out.println();
		repeatPrintChar('-', 74);
	}
	
	public static void repeatPrintChar(char character, int repetition) {
		for (int i = 0; i < repetition; i++) {
			System.out.print(character);
		}
		System.out.println();
	}
	
	public static void printStringWithTrailingSpaces(String printStr, int totalLength) {
		StringBuilder strBuilder = new StringBuilder(printStr);
		for (int i = 0; i < totalLength - printStr.length(); i++) {
			strBuilder.append(' ');
		}
		System.out.print(strBuilder.toString());
	}
	
	public static void printVerticalLine() {
		System.out.print("| ");
	}

}
