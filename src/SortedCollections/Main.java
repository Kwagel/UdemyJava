package SortedCollections;

public class Main {
	private static StockList stockList = new StockList();
	
	public static void main(String[] args) {
		StockItem temp = new StockItem("bread", 0.86, 50);
		stockList.addStock(temp);
		
		temp = new StockItem("eggs", 1.25, 50);
		stockList.addStock(temp);
		temp = new StockItem("car", 12.50, 50);
		stockList.addStock(temp);
		temp = new StockItem("chair", 5.00, 50);
		stockList.addStock(temp);
		temp = new StockItem("cup", 1.00, 50);
		stockList.addStock(temp);
		temp = new StockItem("cup", 1.00, 50);
		stockList.addStock(temp);
		
		
		temp = new StockItem("juice", 4.20, 50);
		stockList.addStock(temp);
		temp = new StockItem("towel", 1.25, 50);
		stockList.addStock(temp);
		temp = new StockItem("vase", 7.50, 50);
		stockList.addStock(temp);
		
		System.out.println(stockList);
		
		for (String s : stockList.items().keySet()) {
			System.out.println(s);
		}
		Basket timsBasket = new Basket("Tim");
		addItem(timsBasket, "car", 1);
		System.out.println(timsBasket);
		
		addItem(timsBasket, "car", 1);
		System.out.println(timsBasket);
		
		if (addItem(timsBasket, "car", 1) != 1) {
			System.out.println("There are no more cars in stock");
		}
		System.out.println(timsBasket);
		
		addItem(timsBasket, "towel", 1);
		addItem(timsBasket, "chair", 1);
		addItem(timsBasket, "cup", 50);
		removeItem(timsBasket, "cup", 250);
		removeItem(timsBasket, "cup", 200);
		addItem(timsBasket, "spanner", 50);
		System.out.println(timsBasket);
		System.out.println(stockList);
		checkout(timsBasket);
//		System.out.println(timsBasket);
		System.out.println(stockList);

//		temp = new StockItem("pen", 1.12);
//		stockList.items().put(temp.getName(), temp);

//		stockList.items().get("car").adjustStock(2000);
////		collection itself is unmodifiable, but the objects inside are
//		stockList.get("car").adjustStock(-1000);
//		System.out.println(stockList);
//		for (Map.Entry<String, Double> price : stockList.priceList().entrySet()) {
//			System.out.println(price.getKey() + ": " + price.getValue());
//		}
	}
	
	public static int addItem(Basket basket, String item, int quantity) {
//		retrieve the item from stock list
		StockItem stockItem = stockList.get(item);
		if (stockItem == null) {
			System.out.println("We don't sell " + item);
			return 0;
		}
		
		if (stockList.reserveStock(item, quantity) != 0 ) {
			basket.addToBasket(stockItem, quantity);
			return quantity;
		}
		return 0;
	}
	
	public static int removeItem(Basket basket, String item, int quantity) {
		StockItem stockItem = stockList.get(item);
		if (stockItem.getReserved() < quantity) {
			System.out.println("Not enough items in basket to remove");
			return 0;
		}
		if (stockList.unreserveStock(item, quantity) != 0 && (stockItem.getReserved() >= quantity)) {
			basket.removeFromBasket(stockItem, quantity);
			return quantity;
		}
		return 0;
	}
	
	public static void checkout(Basket basket) {
		System.out.println("Checking out basket...");

		for (StockItem item : basket.Items().keySet()) {
			item.finaliseStock(item.getReserved());
			
		}
		basket.emptyBasket();
	}
}