import java.util.Collections;
import java.util.Scanner;

public class program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AllContacts contacts = new AllContacts();
		try {
			showMain(contacts);

		} catch (Exception e) {

		}

	}

	public static void showMain(AllContacts c) {
		int ans = 0;
		int loop = -1;
		Scanner s = new Scanner(System.in);
		String firstName = "1234";
		String LastName = "1234";
		String homeNumber = "123456";
		String mobileNum = "123456";

		while (loop != 0) {
			System.out.println("- - - - - - - - - - - - - - -");
			System.out.println("- - - Contact Creator : - - -");
			System.out.println("- - - - - - - - - - - - - - -");
			System.out.println("1. Add/Update Contact");
			System.out.println("2.Remove Contact");
			System.out.println("3.Save Contacts To File");
			System.out.println("4.Load Contacts From File ");
			System.out.println("5.Sort Contacts ");
			System.out.println("6.Search Contact  ");
			System.out.println("7.Print All Contacts");
			System.out.println("- - - - - - - - - - - - - - - ");
			System.out.println("Choose your option or any other key to EXIT.");
			System.out.println("Your Option :");
			ans = s.nextInt();

			switch (ans) {

			case 1:// 1

				System.out.println("Your Option : 1");
				boolean ok = false;
				while (ok == false) {
					ok = true;
					System.out.println("ADD/UPDATE CONTACT:");
					System.out.print("Enter First Name :");
					firstName = s.next();
					System.out.print("Enter Last Name :");
					LastName = s.next();
					System.out.print("Enter Home Number :");
					homeNumber = s.next();
					System.out.print("Enter Mobile Number : ");
					mobileNum = s.next();

					if (firstName.length() < 3 || firstName.isEmpty()) {
						System.out.println(
								"ADD/UPDATE CONTACT EXCEPTION :" + " FIRST NAME CAN NOT BE LESS THAN 3 LETTERS!! ");
						ok = false;
					} else {
						if (LastName.length() < 3 || LastName.isEmpty()) {
							System.out.println(
									"ADD/UPDATE CONTACT EXCEPTION :" + " LAST NAME CAN NOT BE LESS THAN 3 LETTERS!! ");
							ok = false;
						} else {
							if (homeNumber.isEmpty() || mobileNum.isEmpty()
									|| c.checkNumbers(homeNumber, mobileNum) == 0) {
								System.out.println("ADD/UPDATE CONTACT EXCEPTION :"
										+ " Yous Must Enter At Least One Valid ,Mobile Or Home Number! ");
								ok = false;
							}

						}

					}

				}

				Contact contact = new Contact(firstName, LastName, homeNumber, mobileNum);
				c.add(contact);
				System.out.println("CONTACT ADDED !!!");
				break;

			case 2:// 2

				System.out.println("Your Option : 2");
				System.out.println("REMOVE CONTACT :");
				System.out.println("1. By Name");
				System.out.println("2. By Home");
				System.out.println("3. By Mobile");
				char op;
				int choice = 0;
				choice = s.nextInt();
				System.out.println("Your Option: " + choice);
				Contact contact1 = null;
				int index = -1;
				switch (choice) {
				case 1:
					System.out.print("Enter First Name");
					firstName = s.next();
					System.out.print("Enter Last Name :");
					LastName = s.next();
					contact1 = new Contact(firstName, LastName, " ", " ");
					Collections.sort(c, new SortByName_and_Family());
					index = Collections.binarySearch(c, contact1, new SortByName_and_Family());
					contact1 = c.get(index);
					break;
					

				case 2:
					System.out.println("Enter Home Number");
					homeNumber = s.next();
					contact1 = new Contact("", "", homeNumber, "");
					Collections.sort(c, new SortBy_Home());
					index = Collections.binarySearch(c, contact1, new SortBy_Home());
					contact1 = c.get(index);
					break;

				case 3:
					System.out.println("Enter Mobile Number");
					mobileNum = s.next();
					contact1 = new Contact("", "", "", mobileNum);
					Collections.sort(c, new SortBy_Mobile());
					index = Collections.binarySearch(c, contact1, new SortBy_Mobile());
					contact1 = c.get(index);
					break;

				}
				if (contact1 != null) {
					contact1.show();
					System.out.println("Are You Sure? y/n");
					op = s.nextLine().charAt(0);
					if (op == 'y') {
						c.remove(contact1);	
						System.out.println("Contact Removed !!!");
					}
					else
						System.out.println("Operation Canceled!");
				} else
					System.out.println("Contact Not Found!");
				
				c.sort();
				break;
			
			case 3:// 3

				System.out.println("Your Option : 3");
				c.saveContactsToFile();
				break;

			case 4:// 4
				System.out.println("Your Option : 4");
				c.loadContactsFromFile();
				break;

			case 5:// 5
				int answer = 0;
				System.out.println("Your Option : 5");
				System.out.println("SORT CONTACT : ");
				System.out.println("1. By Name");
				System.out.println("2. By Home");
				System.out.println("3. By Mobile");
				answer = s.nextInt();
				System.out.println("Your Option : " + answer);
				switch (answer) {
				case 1:
					c.setComparator(new SortByName_and_Family());

					break;
				case 2:
					c.setComparator(new SortBy_Home());

					break;
				case 3:
					c.setComparator(new SortBy_Mobile());

					break;
				}
				c.sort();
				c.printAll();
				break;

			case 6:// 6

				System.out.println("Your Option : 6");
				System.out.println("SEARCH CONTACT : ");
				System.out.println("1. By Name");
				System.out.println("2. By Home");
				System.out.println("3. By Mobile");
				answer = s.nextInt();
				Contact r = null;
				int index2 = -1;
				switch (answer) {
				case 1:
					System.out.println("Enter First name :");
					firstName = s.next();
					System.out.println("Enter Last Name :");
					LastName = s.next();
					r = new Contact(firstName, LastName, "", "");
					Collections.sort(c, new SortByName_and_Family());
					index2 = Collections.binarySearch(c, r, new SortByName_and_Family());
					r = c.get(index2);
					break;
				case 2:
					System.out.println("Enter Home Number");
					homeNumber = s.next();
					r = new Contact("", "", homeNumber, "");
					Collections.sort(c, new SortBy_Home());
					index2 = Collections.binarySearch(c, r, new SortBy_Home());
					r = c.get(index2);
					break;
				case 3:
					System.out.println("Enter Mobile Number");
					mobileNum = s.next();
					r = new Contact("", "", "", mobileNum);
					Collections.sort(c, new SortBy_Mobile());
					index2 = Collections.binarySearch(c, r, new SortBy_Mobile());
					r = c.get(index2);
					break;

				default:
					break;
				}
				if (r != null)
					r.show();	
				else
					System.out.println("Contact Not Found!");

				break;

			case 7:// 7
				System.out.println("Your Option : 7");
				c.printAll();
				break;

			default:
				System.out.println("Bye Bye ");
				loop = 0;
				break;

			}// close switch
		}

	}
}
