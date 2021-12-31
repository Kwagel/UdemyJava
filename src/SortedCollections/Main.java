package SortedCollections;

public class Main {
	private static StockList stockList = new StockList();
	
	public static void main(String[] args) {
		StockItem temp = new StockItem("bread", 0.86, 100);
		stockList.addStock(temp);
		
		temp = new StockItem("eggs", 1.25, 50);
		stockList.addStock(temp);
		temp = new StockItem("car", 12.50, 2);
		stockList.addStock(temp);
		temp = new StockItem("chair", 5.00, 10);
		stockList.addStock(temp);
		temp = new StockItem("cup", 1.00, 250);
		stockList.addStock(temp);
		temp = new StockItem("cup", 1.00, 7);
		stockList.addStock(temp);
		
		
		temp = new StockItem("juice", 4.20, 75);
		stockList.addStock(temp);
		temp = new StockItem("towel", 1.25, 50);
		stockList.addStock(temp);
		temp = new StockItem("vase", 7.50, 12);
		stockList.addStock(temp);
		
		System.out.println(stockList);
		
		for (String s : stockList.items().keySet()) {
			System.out.println(s);
		}
		Basket timsBasket = new Basket("Tim");
		reserveItem(timsBasket, "car", 1);
		System.out.println(timsBasket);
		
		reserveItem(timsBasket, "car", 1);
		System.out.println(timsBasket);
		
		if (reserveItem(timsBasket, "car", 1) != 1) {
			System.out.println("There are no more cars in stock");
		}
		System.out.println(timsBasket);
		
		reserveItem(timsBasket, "towel", 1);
		reserveItem(timsBasket, "chair", 1);
		reserveItem(timsBasket, "cup", 200);
		unreserveItem(timsBasket, "cup", 250);
		unreserveItem(timsBasket, "cup", 200);
		reserveItem(timsBasket, "spanner", 200);
		System.out.println(timsBasket);
		System.out.println(stockList);
		checkout(timsBasket);
		System.out.println(timsBasket);
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
	
	public static int reserveItem(Basket basket, String item, int quantity) {
//		retrieve the item from stock list
		StockItem stockItem = stockList.get(item);
		if (stockItem == null) {
			System.out.println("We don't sell " + item);
			return 0;
		}
		if ((stockItem.quantityInStock() < Math.abs( stockItem.getReserved()))){
			System.out.println("No more " + stockItem.getName() + " available");
			return  0;
		}
		if (stockList.reserveStock(item, quantity) != 0 && (quantity <= stockItem.getReserved())) {
			basket.addToBasket(stockItem, quantity);
			return quantity;
		}
		return 0;
	}
	public static void unreserveItem(Basket basket, String item, int quantity){
		reserveItem(basket,item,-quantity);
	}
	
	public static void checkout(Basket basket) {
		for (StockItem item : basket.Items().keySet()) {
			item.adjustStock(-item.getReserved());
		}
		basket.emptyBasket();
	}
}