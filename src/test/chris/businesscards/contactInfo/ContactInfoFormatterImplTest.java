package chris.businesscards.contactInfo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ContactInfoFormatterImplTest {

	// since this is a stateless, threadsafe object I see no harm in simply implementing directly in the test
	// once instead of using @Before, etc
	private ContactInfoFormatterImpl formatter = new ContactInfoFormatterImpl();
	
	@Test
	public void testNullFormatter() {
		assertEquals("Name: \nPhone: \nEmail:\n", formatter.format(null));
	}
	
	@Test
	public void testFormatterNullFields() {
		assertEquals("Name: null\nPhone: null\nEmail: null\n", formatter.format(new ContactInfoImpl(null, null, null)));
	}
	
	@Test
	public void testFormatterFields() {
		ContactInfo c = ContactInfoImplTest.build(3);
		assertEquals("Name: " + c.getName() + "\nPhone: " + c.getPhoneNumber() + "\nEmail: " + c.getEmailAddress() + "\n", 
				formatter.format(c));
	}
}
