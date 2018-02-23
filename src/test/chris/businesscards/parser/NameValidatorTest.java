package chris.businesscards.parser;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class NameValidatorTest {

	private final NameValidator nameValidator = new NameValidator();
	
	@Test
	public void testCases() {
		assertFalse("null", nameValidator.isValid(null));
		assertFalse(nameValidator.isValid("ASYMMETRIK LTD"));
		assertTrue(nameValidator.isValid("Mike Smith"));
		assertFalse(nameValidator.isValid("Senior Software Engineer"));
		assertFalse(nameValidator.isValid("(410)555-1234"));
		assertFalse(nameValidator.isValid("msmith@asymmetrik.com"));
		assertFalse(nameValidator.isValid("Foobar Technologies"));
		assertFalse(nameValidator.isValid("Analytic Developer"));
		assertTrue(nameValidator.isValid("Lisa Haung"));
		assertFalse(nameValidator.isValid("1234 Sentry Road"));
		assertFalse(nameValidator.isValid("Columbia, MD 12345"));
		assertFalse(nameValidator.isValid("Phone: 410-555-1234"));
		assertFalse(nameValidator.isValid("Fax: 410-555-4321"));
		assertFalse(nameValidator.isValid("lisa.haung@foobartech.com"));
		assertTrue(nameValidator.isValid("Arthur Wilson"));
		assertFalse(nameValidator.isValid("Software Engineer"));
		assertFalse(nameValidator.isValid("Decision & Security Technologies"));
		assertFalse(nameValidator.isValid("ABC Technologies"));
		assertFalse(nameValidator.isValid("123 North 11th Street"));
		assertFalse(nameValidator.isValid("Suite 229"));
		assertFalse(nameValidator.isValid("Arlington, VA 22209"));
		assertFalse(nameValidator.isValid("Tel: +1 (703) 555-1259"));
		assertFalse(nameValidator.isValid("Fax: +1 (703) 555-1200"));
		assertFalse(nameValidator.isValid("awilson@abctech.com"));
	}
}
