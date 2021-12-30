package AbstractClasses;

public class SearchTree implements NodeList{
	private ListItem root = null;
	
	public SearchTree(ListItem root) {
		this.root = root;
	}
	
	@Override
	public ListItem getRoot() {
		return this.root;
	}
	
	@Override
	public boolean addItem(ListItem newItem) {
		if (this.root == null){
			this.root = newItem;
			return true;
		}
		ListItem currentItem = this.root;
		while (currentItem != null){
			int comparison = currentItem.compareTo(newItem);
			if (comparison < 0 ){
//				if greater, move right if possible;
				if (currentItem.next() != null){
					currentItem = currentItem.next();
				}else{
					currentItem.setNext(newItem);
					return true;
				}
			}else if (comparison > 0 ){
//				if smaller, move left if possible
				if (currentItem.previous() != null){
					currentItem = currentItem.previous();
				}else {
					currentItem.setPrevious(newItem);
					return true;
				}
			}else{
				System.out.println(newItem.getValue() + " is already in the tree");
				return false;
			}
		}
		return false;
	}
	
	@Override
	public boolean removeItem(ListItem item) {
		
		return false;
	}
	
	@Override
	public void traverse(ListItem root) {
//		recursive method
		if (root != null){
			traverse(root.previous());
			System.out.println(root.getValue());
			traverse(root.next());
		}
	
	}
}
