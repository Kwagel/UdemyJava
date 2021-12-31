package Sets;

import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {
	private final Key key;
	private final double orbitalPeriod;
	private final Set<HeavenlyBody> satellites;


//	public static final int STAR = 1;
//	public static final int PLANET = 2;
//	public static final int DWARF_PLANET = 3;
//	public static final int MOON = 4;
//	public static final int COMET = 5;
//	public static final int ASTEROID = 6;\
	
	public enum BodyTypes {
		STAR,
		PLANET,
		DWARF_PLANET,
		MOON,
		COMET,
		ASTEROID,
	}
	
	public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {
		this.orbitalPeriod = orbitalPeriod;
		this.key = new Key(name, bodyType);
		this.satellites = new HashSet<>();
	}
	
	
	public double getOrbitalPeriod() {
		return orbitalPeriod;
	}
	
	public Key getKey() {
		return key;
	}
	
	public boolean addSatellite(HeavenlyBody satellite) {
		return this.satellites.add(satellite);
	}
	
	public Set<HeavenlyBody> getSatellites() {
//		when sending references types, always send a copy so any changes don't affect the original.
		return new HashSet<>(this.satellites);
	}
	
	
	@Override
	public final boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
//		System.out.println("obj.getClass() is " + obj.getClass());
//		System.out.println("this.getClass() is " + this.getClass());
		
		if (obj instanceof HeavenlyBody) {
			HeavenlyBody theObject = (HeavenlyBody) obj;
			return this.key.equals(theObject.getKey());
		}
//		for this program, we are only comparing names of each planet, as they will be unique in the solar system
		return false;
	}
	
	@Override
	public final int hashCode() {
//		System.out.println("HashCode called");
		return this.key.hashCode();
	}
	
	public static Key makeKey(String name, BodyTypes bodyTypes) {
		return new Key(name, bodyTypes);
	}
	
	@Override
	public String toString() {
		return this.key.getName() + ": " + this.key.getBodyTypes() + ", " + this.getOrbitalPeriod();
	}
	
	public static final class Key {
		private String name;
		private BodyTypes bodyTypes;
		
		public Key(String name, BodyTypes bodyTypes) {
			this.name = name;
			this.bodyTypes = bodyTypes;
		}
		
		public String getName() {
			return name;
		}
		
		public BodyTypes getBodyTypes() {
			return bodyTypes;
		}
		
		
		@Override
		public boolean equals(Object obj) {
			Key key = (Key) obj;
			if (this.name.equals(key.getName())) {
				return this.bodyTypes == key.getBodyTypes();
			}
			return false;
		}
		
		@Override
		public int hashCode() {
			return this.name.hashCode() + 57 + this.bodyTypes.hashCode();
		}
		
		@Override
		public String toString() {
			return this.name + ": " + this.bodyTypes;
		}
	}
}
