package IO;

import java.util.LinkedHashMap;
import java.util.Map;

public class Location {
	private final int locationID;
	private final String description;
	private final Map<String, Integer> exits;
	
	public Location(int locationID, String description, Map<String , Integer> exits) {
		this.locationID = locationID;
		this.description = description;
//		creating a copy so when you assign stuff using a temp hashmap, using remove doesn't affect the stored map
		if (exits != null){
			this.exits = new LinkedHashMap<>(exits);
		}else{
			this.exits = new LinkedHashMap<>();
		}
			exits.put("Q", 0);
	}
//	public void addExit(String direction, int location){
//		exits.put(direction, location);
//	}
	public int getLocationID() {
		return locationID;
	}
	
	public String getDescription() {
		return description;
	}
	
	public Map<String, Integer> getExits() {
//		as it returns a copy, you can't modify the original hashmap
		return new LinkedHashMap<>(exits);
	}
	
	protected void addExit(String direction, int location){
		exits.put(direction,location);
	}
}
