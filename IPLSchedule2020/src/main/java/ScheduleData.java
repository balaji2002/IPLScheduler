package main.java;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScheduleData {
	
	public static Map<Integer, String> TEAMS = new HashMap<>();
	static {
		TEAMS.put(1, "RCB");
		TEAMS.put(2, "CSK");
		TEAMS.put(3, "SRH");
		TEAMS.put(4, "KKR");
		TEAMS.put(5, "KXIP");
		TEAMS.put(6, "DC");
		TEAMS.put(7, "RR");
		TEAMS.put(8, "MI");
	}
	
	public static Map<Integer, String> VENUES = new HashMap<>();
	static {
		VENUES.put(1, "Bengaluru");
		VENUES.put(2, "Chennai");
		VENUES.put(3, "Mumbai");
	}
	
	public static List<Schedule> SCHEDULES = new ArrayList<>();
	static {
		SCHEDULES.add(new Schedule(1, 2, 
				new GregorianCalendar(2020, Calendar.DECEMBER, 11, 19, 30).getTime(), 1));
		SCHEDULES.add(new Schedule(1, 3, 
				new GregorianCalendar(2020, Calendar.DECEMBER, 12, 19, 30).getTime(), 2));
		SCHEDULES.add(new Schedule(1, 4, 
				new GregorianCalendar(2020, Calendar.DECEMBER, 13, 19, 30).getTime(), 3));
		SCHEDULES.add(new Schedule(1, 5, 
				new GregorianCalendar(2020, Calendar.DECEMBER, 14, 19, 30).getTime(), 2));
		SCHEDULES.add(new Schedule(1, 6, 
				new GregorianCalendar(2020, Calendar.DECEMBER, 15, 19, 30).getTime(), 1));
		SCHEDULES.add(new Schedule(1, 7, 
				new GregorianCalendar(2020, Calendar.DECEMBER, 16, 19, 30).getTime(), 3));
		SCHEDULES.add(new Schedule(1, 8, 
				new GregorianCalendar(2020, Calendar.DECEMBER, 17, 19, 30).getTime(), 2)); 
		
		SCHEDULES.add(new Schedule(2, 3, 
				new GregorianCalendar(2020, Calendar.DECEMBER, 18, 19, 30).getTime(), 2));
		SCHEDULES.add(new Schedule(2, 4, 
				new GregorianCalendar(2020, Calendar.DECEMBER, 19, 19, 30).getTime(), 3));
		SCHEDULES.add(new Schedule(2, 5, 
				new GregorianCalendar(2020, Calendar.DECEMBER, 20, 19, 30).getTime(), 2));
		SCHEDULES.add(new Schedule(2, 6, 
				new GregorianCalendar(2020, Calendar.DECEMBER, 21, 19, 30).getTime(), 1));
		SCHEDULES.add(new Schedule(2, 7, 
				new GregorianCalendar(2020, Calendar.DECEMBER, 22, 19, 30).getTime(), 3));
		SCHEDULES.add(new Schedule(2, 8, 
				new GregorianCalendar(2020, Calendar.DECEMBER, 23, 19, 30).getTime(), 2));
		
		SCHEDULES.add(new Schedule(3, 4, 
				new GregorianCalendar(2020, Calendar.DECEMBER, 24, 19, 30).getTime(), 3));
		SCHEDULES.add(new Schedule(3, 5, 
				new GregorianCalendar(2020, Calendar.DECEMBER, 25, 19, 30).getTime(), 2));
		SCHEDULES.add(new Schedule(3, 6, 
				new GregorianCalendar(2020, Calendar.DECEMBER, 26, 19, 30).getTime(), 1));
		SCHEDULES.add(new Schedule(3, 7, 
				new GregorianCalendar(2020, Calendar.DECEMBER, 27, 19, 30).getTime(), 3));
		SCHEDULES.add(new Schedule(3, 8, 
				new GregorianCalendar(2020, Calendar.DECEMBER, 28, 19, 30).getTime(), 2));
		
		SCHEDULES.add(new Schedule(4, 5, 
				new GregorianCalendar(2020, Calendar.DECEMBER, 29, 19, 30).getTime(), 2));
		SCHEDULES.add(new Schedule(4, 6, 
				new GregorianCalendar(2020, Calendar.DECEMBER, 30, 19, 30).getTime(), 1));
		SCHEDULES.add(new Schedule(4, 7, 
				new GregorianCalendar(2020, Calendar.DECEMBER, 31, 19, 30).getTime(), 3));
		SCHEDULES.add(new Schedule(4, 8, 
				new GregorianCalendar(2021, Calendar.JANUARY,  01, 19, 30).getTime(), 2));
		
		SCHEDULES.add(new Schedule(5, 6, 
				new GregorianCalendar(2021, Calendar.JANUARY,  02, 19, 30).getTime(), 2));
		SCHEDULES.add(new Schedule(5, 7, 
				new GregorianCalendar(2021, Calendar.JANUARY,  03, 19, 30).getTime(), 2));
		SCHEDULES.add(new Schedule(5, 8, 
				new GregorianCalendar(2021, Calendar.JANUARY,  04, 19, 30).getTime(), 2));
		
		SCHEDULES.add(new Schedule(6, 7, 
				new GregorianCalendar(2021, Calendar.JANUARY,  05, 19, 30).getTime(), 2));
		SCHEDULES.add(new Schedule(6, 8, 
				new GregorianCalendar(2021, Calendar.JANUARY,  06, 19, 30).getTime(), 2));
		
		SCHEDULES.add(new Schedule(7, 8, 
				new GregorianCalendar(2021, Calendar.JANUARY,  06, 19, 30).getTime(), 2));
				
	}
	
	
	public static class Schedule {
		public int team1Id;
		public int team2Id;
		public Date date;
		public int venueId;
		
		public Schedule(int team1, int team2,
				Date tempDate, int venue) {
			team1Id = team1;
			team2Id = team2;
			date = tempDate;
			venueId = venue;
		}
		
		@Override
		public String toString() {
			return "Team1: " + team1Id + ", Team2:" + team2Id + 
					", Date: " + date.toString() + ", Venue: " + venueId;
		}
	}
	
	
	private ScheduleData() {
		
	}
	
}
