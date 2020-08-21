package ui;
import model.*;

import java.time.LocalDate;
import java.util.Scanner;

import exceptions.CannotRegisterException;

public class Menu {
	private final static int TI=1;
	private final static int CC=2;
	private final static int PP=3;
	private final static int FC=4;
	private final static int REGISTER=1;
	private final static int VIEW=2;
	private final static int EXIT=3;
	Scanner sc = new Scanner(System.in);
	private Shop shop;

	public Menu() {
		shop= new Shop();
	}

	public void mainMenu(){
		System.out.println("Welcome to Your Neighborhood Shop");
		int option=0;
		do {
			System.out.println("Select the number that represents what you would like to do");
			System.out.println("1) Register");
			System.out.println("2) View the number of people that have tried to register");
			System.out.println("3) Exit \n");
			option= Integer.parseInt(sc.nextLine());
			if(option>=1 && option<=3) {
				switch(option) {
				case REGISTER: 
					registerMenu();
					break;
				case VIEW: 
					System.out.println("The number of people that have tried to register is: "+shop.getTriedToRegister());
					break;
				case EXIT:
					System.out.println("Thank you for visiting Your Neighborhood Shop");
					break;

				}
			}else {
				System.out.println("Please select a valid option");
			}

		}while(option!=3);

	}
	
	public void registerMenu() {
		int option=0;
		int docType=0;
		int docNum=0;
		do {
			System.out.println("Please select your document type");
			System.out.println("1) Identity Card (TI)");
			System.out.println("2) Citizen Card (CC)");
			System.out.println("3) Passport (PP)");
			System.out.println("4) Foreigner Citizen Card (FCC) \n");
			option= Integer.parseInt(sc.nextLine());
			if(option>=1 && option<=4) {
				switch(option) {
				case TI: 
					docType=TI;
					break;
				case CC: 
					docType=CC;
					break;
				case PP:
					docType=PP;
					break;
				case FC:
					docType=FC;
					break;


				}
			}else {
				System.out.println("Please select a valid option");
			}

		}while(option>4 || option < 1);
		
		System.out.println("Please enter your document number");
		docNum= Integer.parseInt(sc.nextLine());
		
		try {
			shop.register(docType, docNum);
			System.out.println("Person registered succesfully");
		}catch(CannotRegisterException cre) {
			if(cre.getDocType()==TI) {
				System.out.println("Person cannot be registered because it is underage and has"
						+ " an Identification Card, please tell the person to go home");
			}else {
				System.out.println("Person cannot be registered because the second to last number on document"
						+ " does not correspond to todays numbers, please tell the person to go home");
				System.out.println("Todays date is: "+  LocalDate.now().getDayOfMonth()+ " and the persons "
						+ "document number is: "+cre.getDocNum());
			}
			
			
		}
		
		
	}
}
