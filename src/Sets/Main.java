package Sets;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
	private static Map<HeavenlyBody.Key, HeavenlyBody> solarSystem = new HashMap<>();
	private static Set<HeavenlyBody> planets = new HashSet<>();
	
	public static void main(String[] args) {
		HeavenlyBody temp = new Planet("Mercury", 88);
		solarSystem.put(temp.getKey(), temp);
		planets.add(temp);
		temp = new Planet("Venus", 225.0D);
		solarSystem.put(temp.getKey(), temp);
		planets.add(temp);
		temp = new Planet("Earth", 365.0D);
		solarSystem.put(temp.getKey(), temp);
		planets.add(temp);
		HeavenlyBody tempMoon = new Moon("Moon", 27);
		solarSystem.put(tempMoon.getKey(), tempMoon);
		temp.addSatellite(tempMoon);
		temp = new Planet("Mars", 687.0D);
		solarSystem.put(temp.getKey(), temp);
		planets.add(temp);
		tempMoon = new Moon("Deimos", 1.3D);
		solarSystem.put(tempMoon.getKey(), tempMoon);
		temp.addSatellite(tempMoon);
		tempMoon = new Moon("Phobos", 0.3D);
		solarSystem.put(tempMoon.getKey(), tempMoon);
		temp.addSatellite(tempMoon);
		temp = new Planet("Jupiter", 4332.0D);
		solarSystem.put(temp.getKey(), temp);
		planets.add(temp);
		tempMoon = new Moon("Io", 1.8D);
		solarSystem.put(tempMoon.getKey(), tempMoon);
		temp.addSatellite(tempMoon);
		tempMoon = new Moon("Europa", 3.5D);
		solarSystem.put(tempMoon.getKey(), tempMoon);
		temp.addSatellite(tempMoon);
		tempMoon = new Moon("Ganymede", 7.1D);
		solarSystem.put(tempMoon.getKey(), tempMoon);
		temp.addSatellite(tempMoon);
		tempMoon = new Moon("Callisto", 16.7D);
		solarSystem.put(tempMoon.getKey(), tempMoon);
		temp.addSatellite(tempMoon);
		temp = new Planet("Saturn", 10759.0D);
		solarSystem.put(temp.getKey(), temp);
		planets.add(temp);
		temp = new Planet("Uranus", 30660.0D);
		solarSystem.put(temp.getKey(), temp);
		planets.add(temp);
		temp = new Planet("Neptune", 165.0D);
		solarSystem.put(temp.getKey(), temp);
		planets.add(temp);
		temp = new Planet("Pluto", 248.0D);
		solarSystem.put(temp.getKey(), temp);
		planets.add(temp);
		System.out.println("Planets");
		for (HeavenlyBody planet : planets) {
			System.out.println("\t" + planet.getKey());
		}
		
		HeavenlyBody body = solarSystem.get( HeavenlyBody.makeKey("Jupiter", HeavenlyBody.BodyTypes.PLANET));
		System.out.println("==================");
		System.out.println("Moons of Jupiter");
		for (HeavenlyBody jupiterMoon : body.getSatellites()) {
			System.out.println("\t" + jupiterMoon.getKey());
		}
//		Sets allow you to easily join other sets together by using the add all function, as sets cannot contain duplicates
		Set<HeavenlyBody> moons = new HashSet<>();
		for (HeavenlyBody planet : planets) {
			moons.addAll(planet.getSatellites());
			
		}
		System.out.println("==================");
		System.out.println("All Moons");
		for (HeavenlyBody moon : moons) {
			System.out.println(moon);
		}
		
		HeavenlyBody pluto = new DwarfPlanet("Pluto", 842);
		planets.add(pluto);
		System.out.println("==================");
		System.out.println("New Planets");
		for (HeavenlyBody planet : planets) {
			System.out.println(planet);
		}
		System.out.println("==================");
		
		HeavenlyBody earth1 = new Planet("Earth", 365);
		HeavenlyBody earth2 = new Planet("Earth", 365);
		System.out.println(earth1.equals(earth2));
		System.out.println(earth2.equals(earth1));
	
		solarSystem.put(pluto.getKey(), pluto);
		System.out.println(solarSystem.get(HeavenlyBody.makeKey("Pluto", HeavenlyBody.BodyTypes.PLANET)));
		System.out.println(solarSystem.get(HeavenlyBody.makeKey("Pluto", HeavenlyBody.BodyTypes.DWARF_PLANET)));
		
		System.out.println();
		System.out.println("The solar system contains:");
		for (HeavenlyBody heavenlyBody : solarSystem.values()){
			System.out.println(heavenlyBody.getKey());
		}
	
	
	}
}
