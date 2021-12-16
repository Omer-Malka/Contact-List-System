

import java.util.Comparator;

public class SortBy_Home implements Comparator<Contact>{

	@Override
	public int compare(Contact o1, Contact o2) {
		// TODO Auto-generated method stub
		String Home1=o1.getHomeNumber();
		String Home2=(o2).getHomeNumber();
		return Home1.compareTo(Home2); 
	}

}
