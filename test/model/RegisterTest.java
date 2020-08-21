package model;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import exceptions.CannotRegisterException;

class RegisterTest {

	private Shop s ;

	public void setupStage1() {
		s= new Shop();	
		int date= LocalDate.now().getDayOfMonth();
		int lastNumDate= date%10;
		
		try {
			if (lastNumDate%2==0) {
				s.register(2, 79311977);
			}else {
				s.register(2, 79311987);
			}	
		}catch(CannotRegisterException cre){
			fail("Cannot register exception is not expected here");
		}
	}

	public void setupStage2() {
		s= new Shop();	
		
		try {
				s.register(1, 79311977);
				fail("Cannot register exception is expected");
		}catch(CannotRegisterException cre){
			
			
		}
	}
	
	public void setupStage3() {
		s= new Shop();	
		int date= LocalDate.now().getDayOfMonth();
		int lastNumDate= date%10;
		
		try {
			if (lastNumDate%2==0) {
				s.register(2, 66835285);
			}else {
				s.register(2, 66835275);
			}	
			fail("Cannot register exception is expected");
		}catch(CannotRegisterException cre){
			
		}
	}
	

	
	@Test
	void testRegister() {
		setupStage1();
		int date= LocalDate.now().getDayOfMonth();
		int lastNumDate= date%10;
		if (lastNumDate%2==0) {
			assertEquals(2,s.getRegisteredPeople().get(0).getDocType(),"The document type is wrong");
			assertEquals(79311977,s.getRegisteredPeople().get(0).getDocNum(),"The document number is wrong");
		}else {
			assertEquals(2,s.getRegisteredPeople().get(0).getDocType(),"The document type is wrong");
			assertEquals(79311987,s.getRegisteredPeople().get(0).getDocNum(),"The document number is wrong");
		}
		assertEquals(1,s.getTriedToRegister(),"The number of people that have tried to register is wrong");
		
		setupStage2();
		assertEquals(0,s.getRegisteredPeople().size(), "The list is not empty");
		assertEquals(1,s.getTriedToRegister(),"The number of people that have tried to register is wrong");
		
		setupStage3();
		assertEquals(0,s.getRegisteredPeople().size(), "The list is not empty");
		assertEquals(1,s.getTriedToRegister(),"The number of people that have tried to register is wrong");
	}

}
