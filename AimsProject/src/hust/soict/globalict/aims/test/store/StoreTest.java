package hust.soict.globalict.aims.test.store;

import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.store.Store;

public class StoreTest {
	public static void main(String[] args) {
		Media Media1 = new DigitalVideoDisc("The Lion King", "Animation","Roger Allers", 90, 19.95f);
		Media Media2 = new DigitalVideoDisc("Hihi", "Animation","Roger Allers", 93, 19.94f);
		Media Media3 = new DigitalVideoDisc("Hehe", "Animation","Roger Allers", 91, 19.93f);
 
		Store store = new Store();
		store.addMedia(Media1);
		store.addMedia(Media2);
		store.addMedia(Media3);

		Media[] MediaStored = store.getItemsInStore();
		
		for(int i = 0; i < MediaStored.length; i++) {
			if(MediaStored[i] == null) break;
			System.out.println(MediaStored[i].getTitle());
		}
		store.removeMedia(Media1);
		MediaStored = store.getItemsInStore();
		
		for(int i = 0; i < MediaStored.length; i++) {
			if(MediaStored[i] == null) break;
			System.out.println(MediaStored[i].getTitle());
		}
	}
}
