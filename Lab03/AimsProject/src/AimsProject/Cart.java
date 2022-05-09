package AimsProject;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		itemsOrdered[qtyOrdered++] = disc;
	}
	public boolean removeDigitalVideoDisc(DigitalVideoDisc disc) {
		DigitalVideoDisc[] newItemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
		boolean successful = false;
		for(int i = 0, k = 0; i < qtyOrdered; i++) {
			if(itemsOrdered[i].getTitle().equals(disc.getTitle())) {
				successful = true;
				continue;
			}
			newItemsOrdered[k++] = itemsOrdered[i];	
		}
		itemsOrdered = newItemsOrdered;
		if(successful) qtyOrdered--;
		return successful;
	}
	
	public float totalCost() {
		float total = 0;
		for(int i = 0; i < qtyOrdered; i++) {
			total += itemsOrdered[i].getCost();
		}
		return total;
	}
}
