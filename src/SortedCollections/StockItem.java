package SortedCollections;

public class StockItem implements Comparable<StockItem> {
	private final String name;
	private double price;
	private int quantityStock;// can be initialed here
	private int reserved;
	
	public StockItem(String name, double price) {
		this.name = name;
		this.price = price;
		this.quantityStock = 0; //or here(but not both)
		this.reserved = 0;
	}
	
	public StockItem(String name, double price, int quantityStock) {
		this.name = name;
		this.price = price;
		this.quantityStock = quantityStock;
		this.reserved = 0;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getReserved() {
		return reserved;
	}
	
	public int quantityInStock() {
		return quantityStock;
	}
	
	public int availableQuantity() {
		return quantityStock - reserved;
	}
	
	public void setPrice(double price) {
		if (price > 0) {
			this.price = price;
		}
	}
	
	public int reserveItem(int quantity) {
		if (quantity <= availableQuantity()) {
			reserved += quantity;
			return quantity;
		}
		return 0;
	}
	
	public int unreserveItem(int quantity){
		if (quantity <= reserved){
			reserved -= quantity;
			return quantity;
		}
		return 0;
	}
	
	public void adjustStock(int quantityStock) {
		int newQuantity = this.quantityStock + quantityStock;
		if (newQuantity >= 0) {
			this.quantityStock = newQuantity;
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		String objName = ((StockItem) obj).getName();
		return this.name.equals(objName);
	}
	
	@Override
	public int hashCode() {
		return this.name.hashCode() + 31;
	}
	
	@Override
	public int compareTo(StockItem o) {
//		System.out.println("Entering StockItem.compareTo");
		if (this == o) {
			return 0;
		}
		if (o != null) {
			return this.name.compareTo(o.getName());
		}
		throw new NullPointerException();
	}
	
	@Override
	public String toString() {
		return this.name + ": " + String.format("%.2f", this.price);
	}
}


