package com.text.app.flightticketBooking.flight.service;

import java.util.Map;

import com.text.app.flightticketBooking.constant.ApplicationConstant;

class SeatTest {
	public static void main(String[] args) {
		/*int price =1200;
		double tx =11.2;
		double tx2= 9.3;
		int food=230;
		double total  = price+food;
		System.out.println(total);
		
		double tax = tx2-tx;
		System.out.println("tx "+tax);
		total += (total*tax)/100;
		System.out.println(total);*/
		
//		LocalTime t = LocalTime.parse("12:22");
//		System.out.println(t.minusHours(1).minusMinutes(10));
//		
//		LocalDate d = LocalDate.parse("12/02/2019", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//		
//		System.out.println(d.getMonthValue());
		
		
//			Map<Integer, String> seats = new LinkedHashMap<>();
//			for(int i=0; i<10; i++) {
//				seats.put(i+1, "AB CD");
//			}
//		
//			seats.entrySet().forEach(System.out::println);
//			
////			bookSeat("2D", seats);
//			System.out.println("\n______________________________________________________________\n");
//			
//			
//			seats.entrySet().forEach(System.out::println);
//			
////			 Map<Object, Object> val = seats.entrySet().stream().filter(x -> x.getValue().contains("X"));
//			System.out.println("24".charAt(0) -'1');
		
		System.out.println(ApplicationConstant.PATNA_AIRPORT.toLowerCase().contains(ApplicationConstant.PATNA.toLowerCase()));
			
	}
	
	public static Map<Integer, String>  bookSeat(String seatNumber, Map<Integer, String> seats) {
		int row = (seatNumber.charAt(0) - '1') + 1;
		String col = seatNumber.charAt(1) + "";
		System.out.println("Row: " + row + ",   Col:" + col);
		System.out.println(seats.size());
		if (seatNumber.length() > 0) {
			for (Map.Entry<Integer, String> entry : seats.entrySet()) {
				System.out.println(entry.getKey() + "   " + entry.getValue());
				if ((entry.getKey() == row) && (entry.getValue().contains(col))) {
					if (!entry.getValue().contains("X")) {
						entry.setValue(entry.getValue().replace(col, "X"));
					} else {
						throw new RuntimeException("Already booked");
					}
				}
			}

		}
		return seats;
	}
}