package IO;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Main {
	private static Locations locations = new Locations();
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		location ID matches a location description
		
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
			if (direction.length() > 1) {
				String[] words = direction.split(" ");
				for (String word : words) {
					if (directions.containsKey(word)) {
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
