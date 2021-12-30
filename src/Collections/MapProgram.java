package Collections;

import java.util.HashMap;
import java.util.Map;

public class MapProgram {
	
	public static void main(String[] args) {
		Map<String, String> languages = new HashMap<>();
		if (languages.containsKey("Java")) {
			System.out.println("Java already exists");
		} else {
			languages.put("Java", "a compiled, high level, object-orientated, platform independent language");
			System.out.println("Java added successfully");
		}
		languages.put("Python", "an interpreted, object-oriented, high-level programming language with dynamic semantics");
		languages.put("Algol", "an algorithmic language");
//		if there was no previous value, it will output null, as it was null beforehand.
		System.out.println(languages.put("BASIC", "Beginners All Purposes Symbolic Instruction Code"));
		System.out.println(languages.put("Lisp", "Therein lies madness"));
		
		
		if (languages.containsKey("Java")) {
			System.out.println("Java is already in the map");
		} else {
			languages.put("Java", "This is a course about JAva");
		}
//		System.out.println(languages.get("Java"));
////		put returns the previous values inside the HashMap
//		System.out.println(languages.put("Java", "this course is about Java"));
//		System.out.println(languages.get("Java"));
		
		System.out.println("===================");
//		languages.remove("Lisp");
		if (languages.remove("Algol", "an algorithmic language")) {
			System.out.println("Algol removed");
		} else {
			System.out.println("Algol not removed, key/value pair not found");
		}
//		languages.replace replaces value of specified key, and returns previous value
		System.out.println(languages.replace("Scala", "this will not be added"));
//		you can also specify an old and new value which will only replace if it matches, returning true or false accordingly.
//		no need for keys to be immutable like in python(values that cannot change)
		if (languages.replace("Lisp", "Therein lies madness", " a functional programming language with imperative features")) {
			System.out.println("Lisp replaced");
		} else {
			System.out.println("Lisp not replaced");
		}
		
		for (String key : languages.keySet()) {
			System.out.println(key + " : " + languages.get(key));
		}
	}
}
