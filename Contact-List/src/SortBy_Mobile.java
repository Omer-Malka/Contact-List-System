

import java.util.Comparator;

public class SortBy_Mobile implements Comparator<Contact> {

	@Override
	public int compare(Contact o1, Contact o2) {
		// TODO Auto-generated method stub
		String Mobile1=o1.getHomeNumber();
		String Mobile2=o2.getHomeNumber();
		return Mobile1.compareTo(Mobile2); 
	}

}
