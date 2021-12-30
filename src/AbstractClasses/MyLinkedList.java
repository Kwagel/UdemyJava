package AbstractClasses;

public class MyLinkedList implements NodeList {
	private ListItem root = null;
	
	public MyLinkedList(ListItem root) {
		this.root = root;
	}
	
	@Override
	public ListItem getRoot() {
		return this.root;
	}
	
	@Override
	public boolean addItem(ListItem newItem) {
		if (this.root == null) {
//			list is empty, item becomes head
			this.root = newItem;
			return true;
		}
		ListItem currentItem = this.root;
		while (currentItem != null) {
			int comparison = (currentItem.compareTo(newItem));
			if (comparison < 0) {
//				move right if possible, if new item is greater
				if (currentItem.next() != null) {
					currentItem = currentItem.next();
				} else {
//					no next, insert at end of list
					currentItem.setNext(newItem).setPrevious(currentItem);
					
					return true;
				}
			} else if (comparison > 0) {
				if (currentItem.previous() != null) {
//					make previous item  point to new item
//					make the new item in list previous, point to previous item.
					currentItem.previous().setNext(newItem).setPrevious(currentItem.previous());


//					make new item in list next point to the item that used to be next, which is the currentItem

//					finally, make the only next item(the current item) point back to the new item
//					the setPrevious runs on the currentItem. as it returns the item you pass in setNext and setPrevious
					newItem.setNext(currentItem).setPrevious(newItem);
				} else {
//					the node with the previous is the root

//					make new item point next to old root
//					make old root point previously to newItem
					newItem.setNext(this.root).setPrevious(newItem);

//					set the newItem as root
					this.root = newItem;
				}
				return true;
			} else {
				System.out.println(newItem.getValue() + "  is already present, not added");
				return false;
			}
		}
		return false;
	}
	
	@Override
	public boolean removeItem(ListItem item) {
		if (item != null) {
			System.out.println("Deleting item " + item.getValue());
		}
		ListItem currentItem = this.root;
		while (currentItem != null) {
			int comparison = currentItem.compareTo(item);
			if (comparison == 0) {
				if (currentItem == this.root) {
					this.root = currentItem.next();
				} else {
					currentItem.previous().setNext(currentItem.next());
					if (currentItem.next() != null) {
						currentItem.next().setPrevious(currentItem.previous());
					}
				}
				return true;
			} else if (comparison < 0) {
				currentItem = currentItem.next();
			} else {
//				reached an item greater than the one to be deleted
//				item is not in the list
//				System.out.println("Item is not in List");
				return false;
			}
		}
//		reached the end of the list
//		couldn't find item to delete
		return false;
		
	}
	
	@Override
	public void traverse(ListItem root) {
		if (root == null) {
			System.out.println("The list is empty");
		} else {
			while (root != null) {
				System.out.println(root.getValue());
				root = root.next();
			}
		}
//		if (root != null){
//			System.out.println( root.getValue());
//			traverse(root.next());
//		}
	}
}
