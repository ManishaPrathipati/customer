package customer;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

class DuplicateCustomerId extends Exception {

}
class NoCustomerDetailsFound extends Exception {

}

public class CustomerLogic {
	Scanner sc = new Scanner(System.in);

	String nId = "";
	ArrayList<Customer> al = new ArrayList<>();
	TreeSet<String> ts=new TreeSet<String>();
	Customer c = new Customer();
	
	// 1. Add Customer
	public void addCustomer() throws DuplicateCustomerId{
		Customer cm = new Customer();
		System.out.println("enter Customer id");
		String id = sc.next();
		if(ts.contains(id)) {
			int attempt = 1;
			for (int i = 1; i <= attempt; i++) {
				System.out.println(id + " Id Already Exists, Please enter another id");
				id = sc.next();
				if (!(ts.contains(id))) {
					ts.add(id);
					cm.setCustomerId(id);
					break;
				} 
				else if (attempt == 2)
					throw new DuplicateCustomerId();
				else
					attempt++;
			}
		}
		else {
			ts.add(id);
			cm.setCustomerId(id);
		}
		
		System.out.println("enter Customer name");
		String name = sc.next();
		cm.setCustomerName(name);
		System.out.println("enter Customer email-id");
		String email = sc.next();
		cm.setEmailId(email);
		System.out.println("enter Customer mobile no");
		long mblno = sc.nextLong();
		cm.setMobile_No(mblno);
		System.out.println("enter Customer city");
		String city = sc.next();
		cm.setCity(city);
		
		al.add(cm);
		System.out.println(al);

	}

	// Removing Customer by CustomerId
	public void removeCustomer() throws NoCustomerDetailsFound {
		if (al.isEmpty()) {
			//System.out.println("No Customer Details Exists, Add the Customer details to Remove Customer");
			throw new NoCustomerDetailsFound();
		} 
		else {
			System.out.println("Please Select id to remove");
			String id=sc.next();
			int count=0;
			for (int i = 0; i < al.size(); i++) {
				c = al.get(i);
				if (c.getCustomerId().equals(id)) {
					al.remove(i);
					System.out.println(al);
					break;
				}
				else {
					count++;
				}
			}
			if(count==al.size())
				System.out.println(id + " Id not Exists");
		}
	}

	// Updating Customer EmailId by CustomerId
	public void updateCustomerEmailId() throws NoCustomerDetailsFound {
		if (al.isEmpty()) {
			//System.out.println("No Customer Details Exists, Add the Customer details to Update EMail Id");
			throw new NoCustomerDetailsFound();
		}
		else {
			System.out.println("Please Select id to Update EmailId");
			String id=sc.next();
			System.out.println("Please Enter New E-MailId");
			String email=sc.next();
			int count=0;
			for (int i = 0; i < al.size(); i++) {
				c = al.get(i);
				if (c.getCustomerId().equals(id)) {
					c.setEmailId(email);
					System.out.println(al);
				}
				else {
					count++;
				}
			}
			if(count==al.size())
			System.out.println(id + " Id not Exists");
		}
	}

	// Updating Customer Mobile Number by CustomerId
	public void updateCustomerMobileNumber() throws NoCustomerDetailsFound {
		if (al.isEmpty()) {
			//System.out.println("No Customer Details Exists, Add the Customer details to Update Mobile Number");
			throw new NoCustomerDetailsFound();
		} 
		else {
			System.out.println("Please Select id to Update Mobile Number");
			String id=sc.next();
			System.out.println("Please Enter New Mobile Number");
			long mobile=sc.nextLong();
			int count=0;
			for (int i = 0; i < al.size(); i++) {
				c = al.get(i);
				if (c.getCustomerId().equals(id)) {
					c.setMobile_No(mobile);
					System.out.println(al);
				}
				else
					count++;
			}
			if(count==al.size())
				System.out.println(id + " Id not Exists");
		}
	}
	
	//Display Customer Details
	public void displayCustomerDetails() throws NoCustomerDetailsFound {
		if(al.isEmpty()) {
			//System.out.println("No Customer Details Exists, Add the Customer details to Display");
			throw new NoCustomerDetailsFound();
		}
		else
			System.out.println(al);
			
	}

}
