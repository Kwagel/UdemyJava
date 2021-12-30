package Adventure;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.HashMap;
import java.util.Map;

public class Location {
	private final int location ID;
	private final String description;
	private final Map<String, Integer> exits;
	
	public Location(int location, String description) {
		this.location = location;
		this.description = description;
		this.exits = new HashMap<String, Integer>();
	}
	public void addExit(String direction, int location){
		exits.put(direction, location);
	}
	public int getLocation() {
		return location;
	}
	
	public String getDescription() {
		return description;
	}
	
	public Map<String, Integer> getExits() {
		return exits;
	}
}
