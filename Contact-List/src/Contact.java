

import java.io.Serializable;

public class Contact implements Comparable<Contact> , Serializable {
	private String name;
	private String familyName;
	private String homeNumber;
	private String  mobileNumber;
	public static boolean isSortByName=false;
	public static boolean isSortHome=false;
	public static boolean isSortByMobile=false;

	
	
	@Override
	public int compareTo(Contact c) {
		// TODO Auto-generated method stub
//		String name1=((Contact)c).getName();
//		String familyN1=((Contact)c).getFamilyName();
//		return this.getName().compareTo(name1)+ this.getFamilyName().compareTo(familyN1);
//		
		if(isSortByMobile) {
			return c.mobileNumber.compareTo(mobileNumber);
		}
		else {
			if(isSortHome) {
				return c.homeNumber.compareTo(homeNumber);
			}
			else {
				return c.name.compareTo(name)+c.familyName.compareTo(familyName);
			}
		}
			
	}
	

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((familyName == null) ? 0 : familyName.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	
	public boolean equals(Object obj) {
		Contact other = (Contact) obj;
	
		if (other==null)
			return false;
	 if (!familyName.equals(other.familyName))
			return false;
	
	 if (!name.equals(other.name))
			return false;
		 
		 
		return true;
	}

	public Contact(String name, String familyName, String homeNumber, String mobileNumber) {
		setName(name);
		setFamilyName(familyName);
		setHomeNumber(homeNumber);
		setPrivateNumber(mobileNumber);
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getHomeNumber() {
		return homeNumber;
	}

	public void setHomeNumber(String homeNumber) {
		if(homeNumber.length() < 10)
			this.homeNumber = null;
		else
		this.homeNumber = homeNumber;
	}

	public String getPrivateNumber() {
		return mobileNumber;
	}

	public void setPrivateNumber(String privateNumber) {
		if(privateNumber.length() < 11)
			this.mobileNumber = null;
		else
		this.mobileNumber = privateNumber;
	}
	
	public void show() {
		System.out.println("  "+ name + "  " + familyName + "  " + mobileNumber + " " + homeNumber);
		
	}


	
	









}
