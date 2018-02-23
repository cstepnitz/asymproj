package chris.businesscards.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import chris.businesscards.contactInfo.ContactInfo;
import chris.businesscards.contactInfo.ContactInfoImpl;

public class BcpSimpleImplTest {

	private final BCPSimpleImpl impl = new BCPSimpleImpl();	
	private final Validator phoneFinder = new PhoneValidator();
	
	
	//~~~~~~~ test three provided examples, plus an empty file
	@Test 
	public void testArthurWilson() {
		ContactInfo expected = new ContactInfoImpl("Arthur Wilson", "17035551259", "awilson@abctech.com");
		ContactInfo found = impl.getContactInfo(getResourceAsString("arthurWilson.txt"));
		assertEquals(expected, found);
	}

	@Test 
	public void testEmpty() {
		ContactInfo expected = new ContactInfoImpl(null, null, null);
		ContactInfo found = impl.getContactInfo(getResourceAsString("empty.txt"));
		assertEquals(expected, found);
	}
	
	@Test 
	public void testLisaHaung() {
		ContactInfo expected = new ContactInfoImpl("Lisa Haung", "4105551234", "lisa.haung@foobartech.com");
		ContactInfo found = impl.getContactInfo(getResourceAsString("lisaHaung.txt"));
		assertEquals(expected, found);
	}

	@Test 
	public void testMikeSmith() {
		ContactInfo expected = new ContactInfoImpl("Mike Smith", "4105551234", "msmith@asymmetrik.com");
		ContactInfo found = impl.getContactInfo(getResourceAsString("mikeSmith.txt"));
		assertEquals(expected, found);
	}
	
	
	
	private static String getResourceAsString(String resourceName) {
		try {
			return IOUtils.toString(BcpSimpleImplTest.class.getClassLoader().getResourceAsStream(resourceName), StandardCharsets.UTF_8);
		}catch(Exception e) {
			throw new Error(e);
		}
	}
	
	//~~~~~~~ unit test protected methods
	@Test
	public void testFormatPhone() {
		assertEquals(null, impl.formatPhoneNumber(null));
		assertEquals("1234567890", impl.formatPhoneNumber("123-456-7890"));
		assertEquals("4105551234", impl.formatPhoneNumber("(410)555-1234"));
		assertEquals("4105551234", impl.formatPhoneNumber("(410)555-1234"));
		assertEquals("4105551234", impl.formatPhoneNumber("410-555-1234"));
		assertEquals("17035551259", impl.formatPhoneNumber("Tel: +1 (703) 555-1259"));		
	}
	
	@Test
	public void testFormatEmail() {
		assertEquals(null, impl.formatEmail(null));
		assertEquals("msmith@asymmetrik.com", impl.formatEmail("msmith@asymmetrik.com  "));
		assertEquals("lisa.haung@foobartech.com", impl.formatEmail("lisa.haung@foobartech.com "));
		assertEquals("awilson@abctech.com", impl.formatEmail("awilson@abctech.com "));
		assertEquals("msmith@asymmetrik.com", impl.formatEmail("email: msmith@asymmetrik.com"));
		assertEquals("lisa.haung@foobartech.com", impl.formatEmail("email lisa.haung@foobartech.com"));
		assertEquals("awilson@abctech.com", impl.formatEmail("EMAIL awilson@abctech.com"));
		assertEquals("email@abctech.com", impl.formatEmail("email@abctech.com"));
		assertEquals("foo woo", impl.formatEmail("foo woo"));
	}
	
	@Test
	public void testFormatName() {
		assertEquals(null, impl.formatName(null));
		assertEquals("Mike Smith", impl.formatName("Mike Smith"));
		assertEquals("Lisa Haung", impl.formatName("Lisa Haung"));
		assertEquals("Arthur Wilson", impl.formatName("Arthur Wilson"));
		assertEquals("Mike Smith", impl.formatName("NAME Mike Smith"));
		assertEquals("Lisa Haung", impl.formatName("Name: Lisa Haung"));
		assertEquals("Arthur Wilson", impl.formatName("name Arthur Wilson"));
	}
	
	@Test
	public void testFindFirstMatchNull() {
		assertNull(impl.findFirstMatch(null, phoneFinder));
	}
	
	@Test
	public void testFindFirstMatchNullInArray() {
		assertNull(impl.findFirstMatch(new String[] {null}, phoneFinder));
	}
	
	@Test
	public void testFindFirstMatchNoMatch() {
		assertNull(impl.findFirstMatch(new String[] {"chris", "foo", "123", null, "lalal"}, phoneFinder));
	}
	
	@Test
	public void testFindFirstMatchFirst() {
		String phone = "717-333-2222";
		assertEquals(phone, impl.findFirstMatch(new String[] {"chris", "foo", "123", null, phone, "lalal"}, phoneFinder));
	}
	
	@Test
	public void testFindFirstMatchMultipleReturnsFirst() {
		String phone = "717-333-2222";
		assertEquals(phone, impl.findFirstMatch(new String[] {"chris", "foo", "123", null, phone, "lalal", "717-333-2555"}, phoneFinder));
	}
}
