import java.util.Iterator;

public class ContactIterator implements Iterator<Contact> {

	private AllContacts contacts;
	private int index;
	
	public  ContactIterator(AllContacts conList) {
		// TODO Auto-generated constructor stub
		contacts=conList;
		index=-1;
	}
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if (contacts.get(index+1)!=null)
			return true;
		
		return false;
	}

	@Override
	public Contact next() {
		// TODO Auto-generated method stub
		if(hasNext()) {
			Contact c=contacts.get(index+1);
			return c;
		}
		return null;
	}
	
	
	
	
	public void remove() {
		contacts.remove(index);
	}
	

}
