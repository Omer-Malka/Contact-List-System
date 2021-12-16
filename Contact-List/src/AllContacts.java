import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public class AllContacts extends LinkedList<Contact> implements Iterable<Contact> {

	private static final long serialVersionUID = 1L;
	private Comparator<Contact> comparator;

	public AllContacts() {
		super();
		this.comparator = new SortByName_and_Family();// default sort
	}

	public Iterator<Contact> iterator() {
		return new ContactIterator(this);
	}

	public boolean add(Contact c) {

		if (c == null)
			return false;
		Collections.sort(this, new SortByName_and_Family());
		int index = Collections.binarySearch(this, c, new SortByName_and_Family());
		if (index >= 0) {
			super.set(index, c);

		} else {
			super.add(Math.abs(index + 1), c);

		}

		super.sort(comparator);
		return true;

	}

	public Contact remove(int index) {
		if (index >= 0 && index < size())
			return super.remove(index);

		return null;
	}

	public Contact get(int index) {

		if (index >= 0 && index < size())
			return super.get(index);

		return null;

	}

	public void sort() {
		Collections.sort(this, comparator);
	}
	
	public void saveContactsToFile() {
		try (ObjectOutputStream oOut = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream("contacts.obj")))) {
			oOut.writeInt(size());
			for (int i = 0; i < size(); i++)
				oOut.writeObject(get(i));
			System.out.println(size() + "  Contacts Saved!\n");
		} catch (FileNotFoundException e) {
			System.out.println("Save Exception: File contacts.obj Not Found!");
		} catch (IOException e) {
			System.out.println("Save Exception: " + e.getMessage());
		}
	}

	public void loadContactsFromFile() {
		try (ObjectInputStream oIn = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream("contacts.obj")))) {
			int size = size(), count = oIn.readInt(), added = 0, updated = 0, err = 0;
			boolean isLoaded = false;
			while (count > (added + updated + err)) {
				isLoaded = add((Contact) oIn.readObject());
				if (isLoaded) {
					if (size == size())
						updated++;
					else {
						added++;
						size++;
					}
				} else
					err++;
			}
			if (added + updated > 0)
				System.out.printf("%d Contacts Loaded! Added: %d Updated: %d\n", (added + updated), added, updated);
			else
				System.out.println("File Is Empty!");

		} catch (FileNotFoundException e) {
			System.out.println("Load Exception: File contacts.obj Not Found!");
		} catch (IOException e) {
			System.out.println("Load Exception: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Load Exception: File contacts.obj Not Contains Contacts Data!");
		}
	}

	public int checkNumbers(String homeNumber, String mobileNumber) {
		int oneOfTheNumbersIsGood = 0;// not good-false
		int count1 = 0;//home numbers counter 9
		int count2 = 0;//mobile numbers counter 10 

		if (homeNumber.length() > 10) {
			oneOfTheNumbersIsGood = 0;
		} else {
			if (homeNumber.charAt(2) == '-') {
				for (int i = 0; i < homeNumber.length(); i++) {// count the digits 9
					if (Character.isDigit(homeNumber.charAt(i))) {
						count1++;
					}
				}
			
		}
		}
	



		if (mobileNumber.length() > 11) {
			oneOfTheNumbersIsGood = 0;
		} else {
			if (mobileNumber.charAt(3) == '-') {
				for (int i = 0; i < mobileNumber.length(); i++) {// count the digits 9
					if (Character.isDigit(mobileNumber.charAt(i))) {
						count2++;
					}
				}
		}
		}
		if(count1==9 || count2==10) {
			oneOfTheNumbersIsGood = 1;
		}
		else {
			oneOfTheNumbersIsGood=0;
		}
		return oneOfTheNumbersIsGood;
	}
	
//	public int checkNumbers(String homeNumber, String mobileNumber) {
//		int homeNumberIsGood = 0;// not good-false
//		int mobileNumberIsGood = 0;
//		int count1 = 0;//home numbers counter 9
//		int count2 = 0;//mobile numbers counter 10 
//
//		if (homeNumber.length() > 10) {
//			homeNumberIsGood = 0;
//		} else {
//			if (homeNumber.charAt(2) == '-') {
//				for (int i = 0; i < homeNumber.length(); i++) {// count the digits 9
//					if (Character.isDigit(homeNumber.charAt(i))) {
//						count1++;
//					}
//				}
//				if(count1==9)
//				homeNumberIsGood=1;
//			}
//			else {
//				homeNumberIsGood=0;
//			}
//		}
//
//
//
//		if (mobileNumber.length() > 11) {
//			mobileNumberIsGood = 0;
//		} else {
//			if (mobileNumber.charAt(3) == '-') {
//				for (int i = 0; i < mobileNumber.length(); i++) {// count the digits 9
//					if (Character.isDigit(mobileNumber.charAt(i))) {
//						count2++;
//					}
//				}
//				if(count2==10)
//				mobileNumberIsGood=1;
//			}
//			else {
//				mobileNumberIsGood=0;
//			}
//		}
//		
//		if(mobileNumberIsGood - homeNumberIsGood == 0) {
//			return 1;
//		}
//		else {
//			return 0;
//		}
//		
//	}


	public void printAll() {
		System.out.println("Contacts : ");
		if (size() > 0) {
			for (int i = 0; i < size(); i++) {
				System.out.println(Character.toUpperCase(this.get(i).getName().charAt(0)));
				this.get(i).show();;
				//this.get(i).toString();
				System.out.println(" ");
			}
		} else {
			System.out.println("List Is Empty !!!");
		}

	}

	public void setComparator(Comparator comparator) {
		// TODO Auto-generated method stub
		this.comparator = comparator;
	}

}
