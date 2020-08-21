package model;

import java.util.ArrayList;
import exceptions.CannotRegisterException;
import java.time.LocalDate;
public class Shop {
	private final static int TI=1;
	private ArrayList<Person> registeredPeople;

	public Shop() {
		registeredPeople= new ArrayList<Person>();
	}
	
	public void register(int docType, int docNum) throws CannotRegisterException {
		int date= LocalDate.now().getDayOfMonth();
		int lastNumDate= date%10;
		int secondToLastNum= ((docNum/10)%10);
		if(docType==TI) {
			throw new CannotRegisterException(docType, docNum);
		}else if((secondToLastNum%2==0 && lastNumDate%2 ==0) || (secondToLastNum%2!=0 && lastNumDate%2 !=0)) {
			throw new CannotRegisterException(docType, docNum);
		}
		
	Person p= new Person(docType,docNum);
	registeredPeople.add(p);
		
		
	}

	public ArrayList<Person> getRegisteredPeople() {
		return registeredPeople;
	}

}
