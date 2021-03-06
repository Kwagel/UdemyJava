package SortedCollections;

import java.util.*;

public class StockList {
	private final Map<String, StockItem> list;
	
	public StockList() {
		this.list = new LinkedHashMap<>();
	}
	
	public int addStock(StockItem item) {
		if (item != null) {
//			get or default will either retrieve from the list if it exits, or use the obj defined in the second parameter
//			this means you either adding or adjusting a current StockItem if it exists
			StockItem inStock = list.getOrDefault(item.getName(), item);
//			check if already have quantities of this item
			if (inStock != item) {
//			new item
				item.adjustStock(inStock.availableQuantity());
			}
			list.put(item.getName(), item);
			return item.availableQuantity();
		}
		return 0;
	}
	public int sellStock(String item, int quantity){
		StockItem inStock = list.get(item);
		
		if (inStock != null && quantity >0){
			return inStock.finaliseStock(quantity);
		}
		return 0;
	}
	public int reserveStock(String item, int quantity) {

//		if it exists, retrieve item from key in list, otherwise null
		StockItem inStock = list.getOrDefault(item, null);
//		if not null and theres enough stock, and your not taking 0
//		CHECK: not null; quantity is enough after potential sale
		
		if ((inStock != null) && quantity > 0) {
//			remove the stock
//			return amount taken
			return inStock.reserveItem(quantity);
			
		}
//		return amount taken as 0
		return 0;
	}
	
	public int unreserveStock(String item, int quantity) {
		StockItem inStock = list.getOrDefault(item, null);
//		if not null and theres enough stock, and your not taking 0
//		CHECK: not null; quantity is enough after potential sale
		
		if ((inStock != null) && quantity > 0) {
//			remove the stock
//			return amount taken
			return inStock.unreserveItem(quantity);
			
		}
//		return amount taken as 0
		return 0;
	}
	
	public StockItem get(String key) {
//		get SI from key value in list
		return list.get(key);
	}
	
	public Map<String, Double> priceList() {
		Map<String, Double> prices = new LinkedHashMap<>();
		for (Map.Entry<String, StockItem> item : list.entrySet()) {
			prices.put(item.getKey(), item.getValue().getPrice());
		}
		return Collections.unmodifiableMap(prices);
	}
	
	public Map<String, StockItem> items() {
//		better way to make unmodifiable collection objects, as code will know that you cannot change the values and won't let you
		return Collections.unmodifiableMap(list);
	}
	
	@Override
	public String toString() {
		String s = "\nStock List \n";
		double totalCost = 0.0;
		for (Map.Entry<String, StockItem> item : list.entrySet()) {
			StockItem stockItem = item.getValue();
			
			double itemValue = stockItem.getPrice() * stockItem.quantityInStock();
			s = s + stockItem + ". There are " + stockItem.quantityInStock() + " in stock. Value of items: ";
			s = s + String.format("%.2f", itemValue) + "\n";
			totalCost += itemValue;
		}
		return s + "Total stock value: " + String.format("%.2f", totalCost);
	}
}
