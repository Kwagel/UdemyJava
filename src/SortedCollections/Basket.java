package SortedCollections;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Basket {
	private final String name;
	private final Map<StockItem, Integer> list;
	
	public Basket(String name) {
		this.name = name;
		this.list = new TreeMap<>();
	}
	
	public int addToBasket(StockItem item, int quantity) {
//		if item is not null, and you are adding more than one to basket
		if ((item != null) && quantity > 0){
//			if the basket already contains the item and you are adding later, it should retrieve the amount previously added to add extra on, or if not, set it to 0
			int inBasket = list.getOrDefault(item, 0);
//			add or adjust the item on the list, hashmaps can't have duplicate keys and will replace the value instead.
			list.put(item, inBasket + quantity);
			
			return inBasket;
		}
		return 0;
	}
	public int removeFromBasket(StockItem item, int quantity){
		if ((item != null) && quantity > 0){
//			if the basket already contains the item and you are adding later, it should retrieve the amount previously added to add extra on, or if not, set it to 0
			int inBasket = list.getOrDefault(item, 0);
//			add or adjust the item on the list, hashmaps can't have duplicate keys and will replace the value instead.
			list.put(item, inBasket - quantity);
			return inBasket;
		}
		return 0;
	}
	public void emptyBasket() {
		list.clear();
	}
	
	public Map<StockItem, Integer> Items() {
		return Collections.unmodifiableMap(list);
	}
	
	@Override
	public String toString() {
		String s = "\nShopping basket " + name + " contains " + list.size() + ((list.size() == 1) ? " item" : " items") + "\n";
		double totalCost = 0.0;
		for (Map.Entry<StockItem, Integer> item : list.entrySet()) {
//			get key refers to the key to the item map, which is the corresponding stock item and will allow us to retrieve the price from that price
			s = s + item.getKey() + ", " + item.getValue() + " Purchased\n";
			
			totalCost += item.getKey().getPrice() * item.getValue();
			
		}
		return s + "Total Cost: " + totalCost;
	}
}

