package Adventure;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Main {
	private static Map<Integer, Location> locations = new HashMap<>();
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		location ID matches a location description
		locations.put(0, new Location(0, "You are sitting in front of a computer learning Java"));
		locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building"));
		locations.put(2, new Location(2, "You are at the top of a hill"));
		locations.put(3, new Location(3, "You are inside a building, a well house for a small spring"));
		locations.put(4, new Location(4, "You are in a valley beside a stream"));
		locations.put(5, new Location(5, "You are in the forest"));

//		adding valid directions and where they lead to each location
		locations.get(1).addExit("W", 2);
		locations.get(1).addExit("E", 3);
		locations.get(1).addExit("S", 4);
		locations.get(1).addExit("N", 5);
		
		locations.get(2).addExit("N", 5);
		
		locations.get(3).addExit("W", 1);
		
		locations.get(4).addExit("N", 1);
		locations.get(4).addExit("W", 2);
		
		locations.get(5).addExit("S", 1);
		locations.get(5).addExit("W", 2);
		
		Map<String, String> directions = new HashMap<>();
		directions.put("WEST", "W");
		directions.put("EAST", "E");
		directions.put("SOUTH", "S");
		directions.put("NORTH", "N");
		directions.put("QUIT", "Q");
		
		int loc = 1;
		while (true) {
//			get description from location field.
			System.out.println(locations.get(loc).getDescription());
//			if you choose exit, it ends game
			if (loc == 0) {
				break;
			}
//			retrieve map of viable directions
			Map<String, Integer> exits = locations.get(loc).getExits();
//			print avaialbe directions
			System.out.print("Available exits are ");
			for (String exit : exits.keySet()) {
				System.out.print(exit + ", ");
			}
			System.out.println();
//			read direction
			String direction = scanner.nextLine().toUpperCase(Locale.ROOT);
//			Parse phrases, searches for compass direction words
//			String[] inputs = input.split(" ");
//			String direction = "";
//			for (int i = 0; i <= inputs.length -1; i++) {
//				if (directions.containsKey(inputs[i])) {
//					direction = directions.get(inputs[i]);
//					break;
//				}
//			}
			if (direction.length() > 1){
				String[] words = direction.split(" ");
				for (String word : words){
					if (directions.containsKey(word)){
						direction = directions.get(word);
					}
				}
			}

//			if valid direction, set location key for locations from exits values to corresponding direction key
			if (exits.containsKey(direction)) {
				loc = exits.get(direction);
			} else {
				System.out.println("You cant move in that direction");
				
			}
			
		}
		
	}
}
