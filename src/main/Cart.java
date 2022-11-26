package main;

public class Cart {
	public static int MAX_NUMBERS_ORDERED = 20 ;
	private DigitalVideoDisc itemsOrdered [] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED]; 
	private int qtyOrdered = 0 ;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is almost full " );
			return ;
		}
		itemsOrdered[qtyOrdered] = disc ;
		qtyOrdered = qtyOrdered + 1 ;
		System.out.println("The disc has been added" );
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for (int i = 0 ; i < qtyOrdered ; i++ ) {
			if (disc.equals(itemsOrdered[i])) {
//				itemsOrdered[i] = null ;
				for (int j = i ; j < qtyOrdered; j++) {
					itemsOrdered[j] = itemsOrdered[j+1];
				}
				
				itemsOrdered[qtyOrdered-1] = null ; 
				qtyOrdered-- ;
			}
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
		for (DigitalVideoDisc disc : dvdList) {
			this.addDigitalVideoDisc(disc);
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
		this.addDigitalVideoDisc(dvd1);
		this.addDigitalVideoDisc(dvd2);
	}
	
	
	public float totalCost() {
		float sum = 0.0f ; 
		for (int i = 0 ; i < qtyOrdered ; i++ ) {
			sum = sum + itemsOrdered[i].getCost();
		}
		return sum ;
	}
	
	
	
}
