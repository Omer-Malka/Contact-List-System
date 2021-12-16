

import java.util.Comparator;

public class SortByName_and_Family implements Comparator<Contact> {

	@Override
	public int compare(Contact o1, Contact o2) {
		// TODO Auto-generated method stub
		String name1=o1.getName();
		String familyN1=o1.getFamilyName();
		return o2.getName().compareTo(name1)+ o2.getFamilyName().compareTo(familyN1);
		 
	}

}
