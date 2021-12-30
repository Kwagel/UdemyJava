package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		Theatre theatre = new Theatre("The Gate", 8, 12);
//		theatre.getSeats();
//		List<Theatre.Seat> seatCopy = new ArrayList<>(theatre.seats);
//		printList(seatCopy);
//		seatCopy.get(1).reserve();
		if (theatre.reserveSeat("D12")) {
			System.out.println("Please pay" + " for D12");
		} else {
			System.out.println("Seat already reserved");
		}
		if (theatre.reserveSeat("D12")) {
			System.out.println("Please pay" + " for D12");
		} else {
			System.out.println("Seat already reserved");
		}
		
		if (theatre.reserveSeat("B13")) {
			System.out.println("Please pay for B13");
		} else {
			System.out.println("Seat already reserved");
		}
		
		List<Theatre.Seat> reverseSeats = new ArrayList<>(theatre.getSeats());
		Collections.reverse(reverseSeats);
		printList(reverseSeats);
	
		List<Theatre.Seat> priceSeats = new ArrayList<>(theatre.getSeats());
		priceSeats.add(theatre.new Seat("B00", 13.00));
		priceSeats.add(theatre.new Seat("A00", 13.00));
		Collections.sort(priceSeats, Theatre.PRICE_ORDER);
		printList(priceSeats);
//		Collections.shuffle(seatCopy);
//		System.out.println("printing seatCopy");
//		printList(seatCopy);
//		System.out.println("Printing theatre seats");
//		printList(theatre.seats);
//
//		Theatre.Seat minSeat = Collections.min(theatre.seats);
//		Theatre.Seat maxSeat = Collections.max(seatCopy);
//		System.out.println("min seat is " + minSeat.getSeatNumber());
//		System.out.println("max seat is " + maxSeat.getSeatNumber());
//
//		sortList(seatCopy);
//		System.out.println("Printing out sorted list");
//		printList(seatCopy);
		
//		instantiating a new ArrayList with a size doesn't actually fill the arraylist with seats, and Collections.copy works only on lists with values already populated
//		List<Theatre.Seat> newList = new ArrayList<>(theatre.seats.size());

//		you could make another theatre with same parameters, but this doesn't have many use cases
//		Theatre odean = new Theatre("bob", 8, 12);
//		List<Theatre.Seat> newList = new ArrayList<>(odean.seats);
//
//		Collections.copy(newList, theatre.seats);
	}
	
	public static void printList(List<Theatre.Seat> list) {
		for (Theatre.Seat seat : list) {
			System.out.print(" " + seat.getSeatNumber() + " " + seat.getPrice());
			
		}
		System.out.println();
		System.out.println("======================================");
	}
	

}
