package chris.businesscards.parser;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class EmailValidatorTest {

	private EmailValidator val = new EmailValidator();
	
	@Test
	public void testNull() {
		assertFalse(val.isValid(null));
	}
	
	@Test
	public void testVariousEmailValues() {
		assertTrue("Chris@foo.com", val.isValid("Chris@foo.com"));
		assertTrue("Chris234@fo3o.com", val.isValid("Chris234@fo3o.com"));
		assertTrue("2@2.com", val.isValid("2@2.com"));
		assertTrue("\"&7687@foo.com", val.isValid("\"&7687@foo.com"));
		assertTrue("Email: foo@gmail.com", val.isValid("Email: foo@gmail.com"));
		assertTrue("e: foo@gmail.com", val.isValid("e: foo@gmail.com"));
		assertTrue("e foo@gmail.com", val.isValid("e foo@gmail.com"));
		
		assertFalse("Chris@", val.isValid("Chris@"));
		assertFalse("Dancing @ Home", val.isValid("Dancing @ Home"));
		assertFalse("Dancing@Home", val.isValid("Dancing@HomeCorp"));
		assertFalse("null", val.isValid(null));
		
	}
	
}
