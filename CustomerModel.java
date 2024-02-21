package customer;

import java.util.Scanner;

class OptionInCorrectException extends Exception{
	
}

public class CustomerModel {

	private String userName;
	private String password;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public CustomerModel(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	public static void main(String[] args){
		CustomerModel cmodel=new CustomerModel("admin", "admin");
		Scanner scan=new Scanner(System.in);
		System.out.println("Please Enter the User Name");
		String uName=scan.next();
		System.out.println("Please Enter the Password");
		String pass=scan.next();
		
		CustomerLogic clog=new CustomerLogic();
		
		boolean condition=true;
		
		if((cmodel.getUserName().equals(uName)) && (cmodel.getPassword().equals(pass))) {
			while(condition) {
				System.out.println("Please Choose the Option below to perform Various Operations");
				System.out.println("1. Add Customer \n 2. Remove an Existing Customer \n 3. Update Customer Email Id"
						+ "\n 4. Update Customer Mobile Number \n 5. Display all Customers if they Present "
						+ "\n 6. Exit");
				int choice=scan.nextInt();
				switch (choice) {
				case 1: {
					try {
						clog.addCustomer();
					}
					catch (DuplicateCustomerId dci) {
						System.out.println("DuplicateCustomerId occured");
					}
					break;
				}
				case 2: {
					try {
						clog.removeCustomer();
					} catch (NoCustomerDetailsFound e) {
						System.out.println("No Customer Details Exists, Add the Customer details to Remove Customer");
					}
					break;
				}
				case 3: {
					try {
						clog.updateCustomerEmailId();
					} catch (NoCustomerDetailsFound e) {
						System.out.println("No Customer Details Exists, Add the Customer details to Update EMail Id");
					}
					break;
				}
				case 4: {
					try {
						clog.updateCustomerMobileNumber();
					} catch (NoCustomerDetailsFound e) {
						System.out.println("No Customer Details Exists, Add the Customer details to Update Mobile Number");
					}
					break;
				}
				case 5: {
					try {
						clog.displayCustomerDetails();
					} catch (NoCustomerDetailsFound e) {
						System.out.println("No Customer Details Exists, Add the Customer details to Display");
					}
					break;
				}
				case 6: {
					condition=false;
					break;
				}
				default:{
						try {
							throw new OptionInCorrectException();
						}
						catch(OptionInCorrectException oic) {
							System.out.println("You had Choosen the Incorrect Option, Please Choose from the above Menu");
						}
				}
					
				}
			}
		}
		else {
			System.out.println("Sorry..!!! User Credentials are not matching. Please provide valid Credentials to Login");
		}

	}

}
