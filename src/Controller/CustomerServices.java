package Controller;

import java.util.*;
import java.util.Scanner;

import entities.Customer;
import entities.Product;

public class CustomerServices {
	
	Scanner sc= new Scanner(System.in);
	ArrayList<Customer> customers= new ArrayList();
	private static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        private static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";
        private static final String NAME_PATTERN = "^[A-Za-z\\s]+$";
	
	public void register(){
		Customer custDetails= new Customer();
		System.out.println("Enter your Name");
		String name = sc.next();
		if (!Pattern.matches(NAME_PATTERN, name)) {
                System.out.println("Invalid name.");
        }
		
		System.out.println("Enter your phone number");
		long ph = sc.nextLong();
		
		System.out.println("Enter your Email");
		String em = sc.next();
		if (!Pattern.matches(EMAIL_PATTERN, em)) {
               System.out.println("Invalid email");
        }
		
		System.out.println("Enter your Password");
		String psw = sc.next();
		if (!Pattern.matches(PASSWORD_PATTERN, psw)) {
               System.out.println("Weak password");
        }
		
		System.out.println("Confirm Password");
		String cnf = sc.next();
		System.out.println("Enter your Address:");
		String add = sc.next();
		if(cnf.equals(psw)){
			custDetails.setName(name);
			custDetails.setPhone(ph);
			custDetails.setEmail(em);
			custDetails.setPassword(psw);
			custDetails.setAddress(add);
			System.out.println(name + " Registered Successfully");
			customers.add(custDetails);
		}
		else{
			System.out.println("Password does not match");
		
		}
		
	}
	public void login(){
		Customer customer= new Customer();
		System.out.println("Enter your registered email:");
		String email = sc.next();
		if (!Pattern.matches(EMAIL_PATTERN, email)) {
                System.out.println("Invalid email");
        }
		System.out.println("Enter your password");
		String psw = sc.next();
		if (!Pattern.matches(PASSWORD_PATTERN, psw)) {
               System.out.println("Weak password. Password update skipped.");
        }
        
		
		for(int i=0;i<customers.size();i++){
			if (email == customers.get(i).getEmail()){
				if(psw == customers.get(i).getPassword()){
					if(customers.get(i).isActive()==true){
						System.out.println("Login Successfull");
						customer.setLoggedIn(true);
						System.out.println("Enter what you want to perform \n 1. Update \n 2. View Profile \n 3. View Products \n 4. Logout");
						int c= sc.nextInt();
						switch(c){
						case 1:
//							addProducts(product);
							break;
						case 2:
							update();
							break;
						case 3:
							viewProfile(i);
							break;
						case 4:
							viewProduct();
							break;
						case 5:
							logout();
							break;
						default:
							System.out.println("Invalid choice");
						}
						
					}
					else{
						System.out.println("Activate your Account");
					}
				}
				else{
					System.out.println("incorrect password");
				}
			}
			else{
				System.out.println("incorrect email");
			}
		}
		
	}
	
	public void logout(int i) {
        Customer customer = customers.get(i);
        if (customer.isLoggedIn()) {
            customer.setLoggedIn(false);
            System.out.println(customer.getName() + " logged out successfully.");
        } else {
            System.out.println("No user is currently logged in.");
        }
    }
	public void activate(){
		System.out.println("Enter you id");
		int userId= sc.nextInt();
		System.out.println("Enter your password");
		String pswd=  sc.next();
		for(int i=0;i<customers.size();i++){
			if (userId == customers.get(i).getCustomerId()){
				if(pswd == customers.get(i).getPassword()){
					System.out.println("Your account activated successfully");
					customers.get(i).setActive(true);
				}
				else{
					System.out.println("incorrect password");
				}
			}
			else{
				System.out.println("incorrect email");
			}
		}
	}
	
	public void update(){
		System.out.println("Enter your customer ID");
		int id = sc.nextInt();
		System.out.println("Enter your updated name");
		String upname = sc.next();
		if (!Pattern.matches(NAME_PATTERN, upname)) {
            System.out.println("Invalid name. Name update skipped.");
        }
		System.out.println("Enter your updated email");
		String upem = sc.next();
		if (!Pattern.matches(EMAIL_PATTERN, upem)) {
            System.out.println("Invalid email. Email update skipped.");
        }
		System.out.println("Enter your updated password");
		String uppsw = sc.nextLine();
		if (!Pattern.matches(PASSWORD_PATTERN, uppsw)) {
            System.out.println("Weak password. Password update skipped.");
        }
		System.out.println("Enter your updated phone");
		Long upph = sc.nextLong();
		System.out.println("Enter you updated address");
		String upadd = sc.next();
		
		for (int i = 0; i<customers.size(); i++){
			if(customers.get(i).getCustomerId() == id){
				if(upname != "" && Pattern.matches(NAME_PATTERN, upname){
					customers.get(i).setName(upname);
				}
				if(upem != "" && Pattern.matches(EMAIL_PATTERN, upem){
					customers.get(i).setEmail(upem);
				}
				if(uppsw != "" && Pattern.matches(PASSWORD_PATTERN, uppsw){
					customers.get(i).setPassword(uppsw);
				}
				if(upph != null){
					customers.get(i).setPhone(upph);
				}
				if(upadd != ""){
					customers.get(i).setAddress(upadd);
				}
				System.out.println("Details Updated");
			}
		}
		
	}
	public void viewProfile(int i){
		System.out.println("Id :" + customers.get(i).getCustomerId());
		System.out.println("Name :" + customers.get(i).getName());
		System.out.println("Phone No.:"+customers.get(i).getPhone());
		System.out.println("Email ID:"+customers.get(i).getEmail());
		System.out.println("Address :"+customers.get(i).getAddress());
	}
	
	ArrayList<Product> products = new ArrayList<>();
//	products.
//	products.get(1).setQuantity(200);
//	products.get(2).setQuantity(300);
//	products.get(3).setQuantity(400);
//	
//	products.get(0).setId(101);
//	products.get(1).setId(102);
//	products.get(2).setId(103);
//	products.get(3).setId(104);
//	
//	products.get(0).setName("Milk");
//	products.get(1).setName("Water");
//	products.get(2).setName("Bread");
//	products.get(3).setName("Cheese");
//	
//	products.get(0).setPrice(100);
//	products.get(1).setPrice(10);
//	products.get(2).setPrice(100);
	
	public void addProducts(Product product){
		this.products.add(product);
	}
	
	private void viewProduct() {
		// TODO Auto-generated method stub

	}
	
	
	
	public void viewProducts(){
		
	}

}
