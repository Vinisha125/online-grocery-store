package Controller;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("----------------GROCERY APPLICATION-------------");
		System.out.println("Enter 1 for login as Admin, 2 for Customer");
		int x = sc.nextInt();
		switch(x){
			case 1: 
				break;
			case 2:
				System.out.println("Enter your choice from following options\n1. Register \n 2. Login");
				CustomerServices customerService= new CustomerServices();
				while(true){
					int ch = sc.nextInt();
					switch(ch){
					case 1:
						customerService.register();
						break;
					case 2:
						customerService.login();
						break;
					case 3:
						customerService.activate();
						break;
					default:
						System.out.println("Invalid Choice");
					}
				}
			default:
				System.out.println("Invalid Choice");
		}
	}

}
